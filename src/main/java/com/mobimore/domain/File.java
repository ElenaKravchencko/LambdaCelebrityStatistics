package com.mobimore.domain;

import javax.persistence.*;

@Entity
@Table( name = "T_FILE" )
public class File {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "bucket")
    private String bucket;

    @Column(name = "key")
    private String key;

    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBucket() {
        return bucket;
    }
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
