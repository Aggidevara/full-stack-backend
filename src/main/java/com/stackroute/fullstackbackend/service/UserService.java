package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();
//    public List<User> searchByName(String name);
    public User getUserById(Long id);
    public List<User> addFriendByName(long id1,long id2);
    public User deleteUserById(Long id);
    public List<User> recommendLVar(String name, int var);

}
