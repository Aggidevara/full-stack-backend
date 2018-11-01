//package com.stackroute.fullstackbackend.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.fullstackbackend.model.User;
//import com.stackroute.fullstackbackend.service.UserService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private User user,user1;
//    @MockBean
//    private UserService userService;
//    @InjectMocks
//    private UserController userController;
//
//    private List<User> list =null;
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//        user = new User();
//        user1=new User();
//        user.setUserName("aish123");
//        user.setId(4l);
//        user.setAge(12);
//        user.setBirthdate("12/54");
//        user.setName("aish");
//        user.setDescription("waakd");
//        user.setUser(null);
//
//        user1.setId(3l);
//        user1.setUserName("swe1");
//        user1.setAge(12);
//        user1.setBirthdate("12/54");
//        user1.setName("swe");
//        user1.setDescription("waakd");
//        list = new ArrayList<>();
//        list.add(user);
//        list.add(user1);
//        System.out.println(list);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void addUser() throws Exception {
//        when(userService.getAllUsers()).thenReturn(list);
//        System.out.println(list);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/adduser")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllUser() throws Exception{
//        when(userService.getAllUsers()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getuser")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void addFriend() throws Exception{
//        System.out.println(list);
//        when(userService.addFriendByName(user.getId(),user.getId())).thenReturn(list);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/v1/addfriend/3/4")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//    @Test
//    public void recommendFriend() {
//    }
//
//    @Test
//    public void deleteUser() throws Exception {
//        when(userService.deleteUserById(user.getId())).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders
//                .delete("/api/v1/deleteuser/4")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void deleteUserFriend() throws Exception {
//        when(userService.deleteUserFriendsByName(user.getId())).thenReturn(true);
//        mockMvc.perform(MockMvcRequestBuilders
//        .delete("/api/v1/deleteuserfriend/4")
//        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andDo(MockMvcResultHandlers.print());
//
//
//    }
//
//    @Test
//    public void getUserFriends() throws Exception {
//        when(userService.getUserfriends(user.getId())).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders
//        .get("/api/v1/userfriends/4")
//        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//
//    }
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
//}