package com.stackroute.fullstackbackend.controller;


import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
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
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.OK);
        return responseEntity;
    }


    @GetMapping("getuserfriends/{username}")
    public ResponseEntity<?> getUserFriends(@PathVariable("username") String username) {
        List<User> user1 = userService.getUserFriends(username);
        ResponseEntity responseEntity = new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("deleteuser/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
        boolean user=userService.deleteUserByUsername(username);
        ResponseEntity responseEntity=new ResponseEntity<Boolean>(true,HttpStatus.OK);

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


    @GetMapping("searchusers/{name}")
    public  ResponseEntity<User> searchUsersByName(@PathVariable("name") String name){

        List<User> user=userService.searchUsersByName(name);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user,HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("getUserDetails/{username}")
    public ResponseEntity<User> getUserDetails(@PathVariable("username") String username){
        User user1=userService.getUserDetails(username);
        ResponseEntity responseEntity=new ResponseEntity<User>(user1, HttpStatus.CREATED);
        return responseEntity;
    }
    @DeleteMapping("deleteuserfriend/{username1}/{username2}")
    public  ResponseEntity<User> deleteUserFriend(@PathVariable("username1") String username1,@PathVariable("username2") String username2){        User user=userService.deleteUserFriendsByName(username1, username2);
        ResponseEntity responseEntity=new ResponseEntity<User>(user,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("getUserFriendsDetails/{username}")
    public ResponseEntity<?> getUserFriendsDetails(@PathVariable("username") String username){
       List<User> user1=userService.getUserFriends(username);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }

}
