package com.stackroute.fullstackbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.service.UserService;
import com.stackroute.fullstackbackend.service.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllersTest {
    @Autowired
    private MockMvc mockMvc;
    private User user,user1,user2;
    @MockBean
    private UserServiceImpl userService;
    @InjectMocks
    private UserController userController;

    private List<User> list =null;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user1 = new User();
        user = new User();
        user2 = new User();
        user1.setId(3l);
        user1.setUsername("swe1");
        user1.setAge(12);
        user1.setBirthdate("12/54");
        user1.setName("swe");
        user1.setDescription("waakd");
        user1.setFriends(user.getId());

        user2.setId(5l);
        user2.setUsername("rhea123");
        user2.setAge(11);
        user2.setBirthdate("12/54");
        user2.setName("def");
        user2.setDescription("waakd");
        user2.friends.add(user.getId());
//        user2.friends.add(user1.getId());

        user.setId(4l);
        user.setUsername("aish123");
        user.setAge(11);
        user.setBirthdate("12/54");
        user.setName("abc");
        user.setDescription("waakd");
        user.friends.add(user1.getId());
        user.friends.add(user2.getId());




        list = new ArrayList<>();
//        list.add(user);
        list.add(user1);
        list.add(user);
        list.add(user2);
//        System.out.println(list);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUser() throws Exception {
        when(userService.addUser(user1)).thenReturn(user1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user1)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getAllUser() throws Exception{
        when(userService.getAllUsers()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getuser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getUserFriends() throws Exception {
        when(userService.getUserFriends(user.getUsername())).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getuserfriends/aish123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user1)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteUser() throws Exception {
        when(userService.deleteUserByUsername(user.getUsername())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/deleteuser/aish123")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void addFriend() throws Exception {

        when(userService.addFriendByName(user.getUsername(),user1.getUsername())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/addfriend/aish123/swet1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void recommendFriend() throws Exception {

        when(userService.recommendLVar(user.getUsername(),1)).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recommendL1/rhea123/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
@Test
public void recommendFriendLevel1() throws Exception{

    when(userService.recommendLVar(user.getUsername(),1)).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recommendL1/aish123/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(list)))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andDo(MockMvcResultHandlers.print());
}
    @Test
    public void searchUsersByName() {
    }

    @Test
    public void getUserDetails() throws Exception {
        when(userService.getUserDetails(user.getUsername())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getUserDetails/aish123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user1)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteUserFriend() {
    }
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}