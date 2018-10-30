package com.stackroute.fullstackbackend.model;

import org.neo4j.ogm.annotation.*;

import java.awt.*;
import java.util.Set;

@NodeEntity
public class User {
    @GraphId
    private Long id;

    private String name;
    private Integer age;
    private String birthdate;
//    private Image imageUrl;
    private String description;
    @Relationship(type="friend")
    public Set<Long> user;

    public User() {
    }

    public User(String name, Integer age, String birthdate, String description) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.description = description;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

//    public Image getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(Image imageUrl) {
//        this.imageUrl = imageUrl;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getuser() {
        return user;
    }

    public void setuser(Set<Long> user) {
        this.user = user;
    }
}
