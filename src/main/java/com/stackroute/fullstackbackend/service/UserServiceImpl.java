package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

   UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;

    }

    @Override
    public User addUser(User user) {
        User addedUser=userRepo.save(user);
        return addedUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= (List<User>) userRepo.getAllUsers();
        return users;
    }

//    @Override
//    public List<User> searchByName(String name) {
//        List<User> user= new ArrayList<>();
//        user=  userRepo.getByName(name);
//        return user;
//    }

    @Override
    public User getUserById(Long id) {
        User user1=userRepo.findById(id).get();
        return user1;
    }

    @Override
    public User addFriendByName(String name) {
        User friend=  userRepo.getByName(name);
        friend=userRepo.addFriend(friend);
        return friend;
    }

    @Override
    public User deleteUserById(Long id) {
        User deleteuser=userRepo.findById(id).get();
        return deleteuser;
    }
}