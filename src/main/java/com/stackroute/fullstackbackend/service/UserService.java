package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

    public List<User> addFriendByName(long id1, long id2);//username..

    public boolean deleteUserByUsername(String username);//username

    public boolean deleteUserFriendsByName(String username);//friends username

    public List<User> getUserfriends(Long id);//my username

    List<User> searchUsersByName(String input);

   public User getUserDetails(String username);

}