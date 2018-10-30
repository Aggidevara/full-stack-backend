package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();
//    public List<User> searchByName(String name);
    public User getUserById(Long id);
    public User addFriendByName(String name);
    public User deleteUserById(Long id);

}
