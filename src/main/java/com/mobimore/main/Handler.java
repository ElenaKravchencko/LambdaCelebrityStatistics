package com.mobimore.main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2ProxyResponseEvent;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.CollectionUtils;
import com.amazonaws.util.IOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobimore.domain.File;
import com.mobimore.domain.Request;
import com.mobimore.model.Actor;
import com.mobimore.model.ActorStatistics;
import com.mobimore.model.ImageBase64;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.ByteArrayInputStream;
import java.util.*;

public class Handler implements RequestHandler<APIGatewayV2ProxyRequestEvent, APIGatewayV2ProxyResponseEvent> {
  private LambdaLogger logger;
  private final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  @Override
  public APIGatewayV2ProxyResponseEvent handleRequest(APIGatewayV2ProxyRequestEvent event, Context context) {
    logger = context.getLogger();

    String eventBody = event.getBody();
    if (eventBody != null && !eventBody.isEmpty()) {
      Actor actor = gson.fromJson(eventBody, Actor.class);
      String actorName = actor.getName();
      ActorStatistics statistics = getActorStatisticsFromDB(actorName);
      if (statistics == null) {
        return createErrorResponse("image not found for name: " + actorName);
      }

      APIGatewayV2ProxyResponseEvent response = new APIGatewayV2ProxyResponseEvent();
      response.setIsBase64Encoded(false);
      response.setStatusCode(200);
      HashMap<String, String> headers = new HashMap<>();
      headers.put("Content-Type", "text/html");
      response.setHeaders(headers);

      String body = gson.toJson(statistics);
      response.setBody(body);
      return response;
    }
    return createErrorResponse("error processing your request");
  }

  private APIGatewayV2ProxyResponseEvent createErrorResponse(String message) {
    APIGatewayV2ProxyResponseEvent response = new APIGatewayV2ProxyResponseEvent();
    response.setIsBase64Encoded(false);
    response.setStatusCode(404);
    HashMap<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "text/html");
    response.setHeaders(headers);
    response.setBody("{\n\"message\":" + "\"" + message + "\"" + "}");
    return response;
  }

  private ActorStatistics getActorStatisticsFromDB(String actorName) {
    SessionFactory s = HibernateUtil.getSessionFactory();
    Session session = s.openSession();
    session.beginTransaction();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Request> query = builder.createQuery(Request.class);
    Root<Request> root = query.from(Request.class);

    query.select(root).where(builder.equal(root.get("name"), actorName)).orderBy(builder.desc(root.get("queryTimeStamp")));

    try {
      List<Request> requests = session.createQuery(query).getResultList();
      if (!CollectionUtils.isNullOrEmpty(requests)) {
        ActorStatistics statistics = new ActorStatistics();

        List<ImageBase64> imagesBase64 = new ArrayList<>();
        File s3File = requests.get(0).getImage();
        byte[] imageBytes = getFileFromS3(s3File);
        if (imageBytes != null && imageBytes.length != 0) {
          ImageBase64 imageBase64 = new ImageBase64();
          imageBase64.setData(Base64.getEncoder().encodeToString(imageBytes));
          imagesBase64.add(imageBase64);
        } else {
          return null;
        }

        statistics.setSearchCount(requests.size());
        statistics.setImageBase64(imagesBase64);
        return statistics;
      }
      return null;
    } catch (Exception e) {
      return null;
    } finally {
      session.getTransaction().commit();
      session.close();
    }
  }

  private byte[] getFileFromS3(File file) {
    try {
      S3Object s3Object = s3Client.getObject(file.getBucket(), file.getKey());
      if (s3Object != null) {
        byte[] imageBase64 = IOUtils.toByteArray(s3Object.getObjectContent());
        if (imageBase64 != null) {
          return imageBase64;
        }
      }
    } catch (Exception e) {
      return null;
    }
    return null;
  }
}
