package com.stackroute.fullstackbackend.controller;


import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("adduser")
    public ResponseEntity<?> addUser(@RequestBody User user){
     User user1=userService.addUser(user);
     ResponseEntity responseEntity=new ResponseEntity<String>("added succcessfully", HttpStatus.CREATED);
     return responseEntity;
    }

    @GetMapping("getuser")
    public ResponseEntity<?> getAllUser(){
        List<User> user1=userService.getAllUsers();
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("getuserfriends/{username}")
    public ResponseEntity<?> getUserFriends(@PathVariable("username") String username){
        List<User> user1=userService.getUserFriends(username);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }
    @PutMapping("addfriend/{username1}/{username2}")
    public ResponseEntity<?> addFriend(@PathVariable("username1") String username1, @PathVariable("username2") String username2){
       boolean user1= userService.addFriendByName(username1,username2);
        ResponseEntity responseEntity;
      // if(user1) {
           responseEntity = new ResponseEntity<String>("friend made", HttpStatus.CREATED);

           return responseEntity;
       //}

    }


    @GetMapping("recommendL1/{username}/{var}")
    public ResponseEntity<?> recommendFriend(@PathVariable("username") String userName, @PathVariable("var") int var){
        List<User> user1= userService.recommendLVar(userName, var);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }


//    @GetMapping("userfriends/{id}")
//    public  ResponseEntity<?> getUserFriends(@PathVariable("id") Long id){
//
//        List<User> user=userService.getUserfriends(id);
//        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user,HttpStatus.OK);
//        return responseEntity;
//    }

    @GetMapping("searchUsers/{name}")
    public  ResponseEntity<?> searchUsersByName(@PathVariable("name") String name){
        List<User> user=userService.searchUsersByName(name);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user,HttpStatus.OK);
        return responseEntity;
    }


}
