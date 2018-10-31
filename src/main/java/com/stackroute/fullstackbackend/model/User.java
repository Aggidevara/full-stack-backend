package com.stackroute.fullstackbackend.model;

import org.neo4j.ogm.annotation.*;

import java.awt.*;
import java.util.Set;

@NodeEntity
public class User {
    @GraphId
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private String birthdate;
//    private Image imageUrl;
    private String description;
    @Relationship(type="friend")
    public Set<User> friends;

    public User() {
    }

    public User(String username,String name, Integer age, String birthdate, String description ,Set friends) {
        this.username=username;
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.description = description;
        this.friends= friends;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
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


}
