package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

    public List<User> addFriendByName(long id1, long id2);

    public boolean deleteUserById(Long id);

    public boolean deleteUserFriendsByName(Long id);

    public List<User> getUserfriends(Long id);
//    public List<User> getLevel2Friends(long id);

}