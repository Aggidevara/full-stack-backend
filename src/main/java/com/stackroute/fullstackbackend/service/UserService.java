package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();


    public boolean addFriendByName(String username1, String username2);


    public List<User> recommendLVar(String name, int var);


    public List<User> searchUsersByName(String input);

    public List<User> getUserFriends(String username);



    public boolean deleteUserByUsername(String username);//username



   public User getUserDetails(String username);

    public User deleteUserFriendsByName(String username1, String username2);
}
