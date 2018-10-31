package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

    public List<User> recommendLVar(String name, int var);

    public boolean deleteUserByUsername(String username);//username

    public boolean deleteUserFriendsByName(String username);//friends username

    List<User> searchUsersByName(String input);

   public User getUserDetails(String username);

}
