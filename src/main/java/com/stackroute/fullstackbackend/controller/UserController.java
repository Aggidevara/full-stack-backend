package com.stackroute.fullstackbackend.controller;


import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("adduser")
    public ResponseEntity<User> addUser(@RequestBody User user){
     User user1=userService.addUser(user);
     ResponseEntity responseEntity=new ResponseEntity<String>("added succcessfully", HttpStatus.CREATED);
     return responseEntity;
    }
    @GetMapping("getuser")
    public ResponseEntity<User> getAllUser(){
        List<User> user1=userService.getAllUsers();
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("addfriend/{id1}/{id2}")
    public ResponseEntity<User> addFriend(@PathVariable("id1") Long firstId, @PathVariable("id2") Long secondId){
       List<User> user1= userService.addFriendByName(firstId,secondId);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }


    @GetMapping("recommendL1/{name}/{var}")
    public ResponseEntity<User> recommendFriend(@PathVariable("name") String name, @PathVariable("var") int var){
        List<User> user1= userService.recommendLVar(name, var);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }


    @DeleteMapping("deleteuser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){

        boolean user=userService.deleteUserById(id);
        ResponseEntity responseEntity=new ResponseEntity<String>("deleted Successfully",HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("deleteuserfriend/{id}")
    public  ResponseEntity<User> deleteUserFriend(@PathVariable("id") Long id){

        boolean user=userService.deleteUserFriendsByName(id);
        ResponseEntity responseEntity=new ResponseEntity<String>("deleted Successfully from your friend list",HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("userfriends/{id}")
    public  ResponseEntity<User> getUserFriends(@PathVariable("id") Long id){

        List<User> user=userService.getUserfriends(id);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user,HttpStatus.OK);
        return responseEntity;
    }

}
