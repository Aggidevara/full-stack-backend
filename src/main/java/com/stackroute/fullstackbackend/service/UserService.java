package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.exceptions.UserAlreadyExistsException;
import com.stackroute.fullstackbackend.exceptions.UserNotFoundException;
import com.stackroute.fullstackbackend.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User addUser(User user) throws UserAlreadyExistsException;

    public List<User> getAllUsers();



    public boolean addFriendByName(String username1, String username2);

   // public User getUserById(Long id);
//    public boolean addFriendByName(String username1, String username2) throws UserAlreadyExistsException;


    public List<User> recommendLVar(String name, int var);


    public List<User> searchUsersByName(String input) throws Exception;


    public List<User> getUserFriends(String username) ;

    public boolean deleteUserByUsername(String username);//username

    public User getUserDetails(String username);

    public User deleteUserFriendsByName(String username1, String username2);
}
