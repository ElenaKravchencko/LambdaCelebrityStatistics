package com.mobimore.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (null != sessionFactory)
            return sessionFactory;

        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
