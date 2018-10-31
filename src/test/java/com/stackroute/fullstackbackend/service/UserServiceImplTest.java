package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.repository.UserRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    User user1;

    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserServiceImpl userService;
    List<User> list= null;
    Optional optional;

    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user1 = new User("Noor",21,"23-11-96","foodieee");
        list = new ArrayList<>();
        list.add(user1);
        optional= Optional.of(user1);

    }

    @Test
    public void addUser() {

        when(userRepo.save((User)any())).thenReturn(user1);
        User savedUser= userService.addUser(user1);
        Assert.assertEquals(user1, savedUser);
    }

    @Test
    public void getAllUsers() {

    when(userRepo.getAllUsers()).thenReturn(list);
    List<User> userList= userService.getAllUsers();
    Assert.assertEquals(list, userList);
    }

    @Test
    public void addFriendByName() {
        when(userRepo.findById(user1.getId())).thenReturn(optional);
//        when(userRepo.findById(user2.getId())).thenReturn(optional)
;    }

    @Test
    public void deleteUserById() {

    }

    @Test
    public void recommendLVar() {
    }

    @Test
    public void deleteUserFriendsByName() {
    }

    @Test
    public void getUserfriends() {
    }
}