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
    @PostMapping("addfriend")

    public ResponseEntity<User> getFriendbyName(@RequestBody User user){
        User user1=userService.addFriendByName(user.getName());
        ResponseEntity responseEntity=new ResponseEntity<User>(user1, HttpStatus.CREATED);
        return responseEntity;
    }
}