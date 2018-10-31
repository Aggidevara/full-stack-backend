package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.model.User;
import com.stackroute.fullstackbackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

//    @Override
//    public User getUserById(Long id) {
//        User user1=userRepo.findById(id).get();
//        return user1;
//    }

    @Override

    public boolean addFriendByName(String username1,String username2) {

        try {

            System.out.println("the parameter data is  "+username1+"  "+username2);
            User friend = userRepo.makeFriend(username1, username2);

           User u1= userRepo.existsByName(username1);
           User u2= userRepo.existsByName(username2);
           u1.setFriends(u2.getId());
           u2.setFriends(u1.getId());
           userRepo.save(u1);
           userRepo.save(u2);
            return true;

        }
        catch(Exception e){
            return false;}
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        boolean deleteuser=userRepo.deleteUserByUsername(username);
        return deleteuser;
    }


    public List<User> recommendLVar(String name, int var){

        if(var==1) {
            List<User> level1 = userRepo.recommendL1(name);
            return level1;
        }
        else if(var==2){
            List<User> level2 = userRepo.recommendL2(name);
            return level2;
        }
        else{

            return null;
        }
    }




    @Override
    public List<User> getUserFriends(String username) {
   List<Long> lists= userRepo.existsByName(username).getFriends();
        List<User> friendslist=new ArrayList<>() ;
//        Iterator it= lists.iterator();
//                while(it.hasNext()){
//                    friendslist.add(userRepo.findById(new Long(it.next())).get());
//                }
        for(int i=0;i<lists.size();i++){
            friendslist.add(userRepo.findById(lists.get(i)).get());
        }


        return friendslist;
    }
@Override
    public User getUserDetails(String username) {
        User userdetails= userRepo.getUserDetails(username);

        return userdetails;

    }
    @Override
    public List<User> searchUsersByName(String input){
        List<User> userList=(List)userRepo.getAllUsers();
        List<User> matchedList=new ArrayList<>();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getName().toLowerCase().matches("(.*)"+input.toLowerCase()+"(.*)"))
                matchedList.add(userList.get(i));
        }
        return matchedList;
    }

    @Override
    public User deleteUserFriendsByName(String username1, String username2) {
        User loggedInUser = userRepo.deleteUserfriendsByName(username1, username2);
        return loggedInUser;
    }

}
