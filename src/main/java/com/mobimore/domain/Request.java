package com.mobimore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File image;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date queryTimeStamp;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public File getImage() {
        return image;
    }
    public void setImage(File post) {
        this.image = post;
    }

    public Date getQueryTimeStamp() {
        return queryTimeStamp;
    }
    public void setQueryTimeStamp(Date queryTimeStamp) {
        this.queryTimeStamp = queryTimeStamp;
    }
}
