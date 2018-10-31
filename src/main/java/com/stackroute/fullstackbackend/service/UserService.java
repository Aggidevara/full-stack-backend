package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

   // public User getUserById(Long id);
    public boolean addFriendByName(String username1, String username2);

    public List<User> recommendLVar(String name, int var);

    public boolean deleteUserById(String username);

    public boolean deleteUserFriendsByName(Long id);

//    public List<User> getUserfriends(Long id);

    public List<User> searchUsersByName(String input);

    public List<User> getUserFriends(String username);

}
