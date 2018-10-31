package com.stackroute.fullstackbackend.controller;


import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //@CrossOrigin("*")
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


    @DeleteMapping("deleteuser/{username}")
    public ResponseEntity<User> deleteUser(@PathVariable("username") String username){
        boolean user=userService.deleteUserByUsername(username);
        ResponseEntity responseEntity=new ResponseEntity<String>("deleted Successfully",HttpStatus.OK);
        return responseEntity;
    }




    @GetMapping("recommendL1/{name}/{var}")
    public ResponseEntity<User> recommendFriend(@PathVariable("name") String name, @PathVariable("var") int var){
        List<User> user1= userService.recommendLVar(name, var);
        ResponseEntity responseEntity=new ResponseEntity<List<User>>(user1, HttpStatus.CREATED);
        return responseEntity;
    }


    @DeleteMapping("deleteuserfriend/{username}")
    public  ResponseEntity<User> deleteUserFriend(@PathVariable("username") String username){

        boolean user=userService.deleteUserFriendsByName(username);
        ResponseEntity responseEntity=new ResponseEntity<String>("deleted Successfully from your friend list",HttpStatus.OK);
        return responseEntity;
    }

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

}
