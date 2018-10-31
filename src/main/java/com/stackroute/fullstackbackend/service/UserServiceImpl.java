package com.stackroute.fullstackbackend.service;

import com.stackroute.fullstackbackend.exceptions.UserAlreadyExistsException;
import com.stackroute.fullstackbackend.exceptions.UserNotFoundException;
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
        User addedUser=null;
        User username=userRepo.existsByName(user.getUsername());
//        if(username.getName()==user.getName()){
//            throw new UserAlreadyExistsException("User Already Exists");
//        }
            addedUser=userRepo.save(user);


        return addedUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= (List<User>) userRepo.getAllUsers();
        return users;
    }


    @Override

    public boolean addFriendByName(String username1,String username2) throws UserAlreadyExistsException{


            System.out.println("the parameter data is  "+username1+"  "+username2);
            User friend = null;
            friend=userRepo.makeFriend(username1, username2);
            boolean value=true;
            User u1= userRepo.existsByName(username1);
            User u2= userRepo.existsByName(username2);
            for(int i=0;i<u1.friends.size();i++){
               if(u2.getId()==u1.friends.get(i)){
                   value=false;
                   break;
               }
           }
           if(value) {
            u1.setFriends(u2.getId());
            u2.setFriends(u1.getId());
            userRepo.save(u1);
            userRepo.save(u2);
            return true;
        }
            return false;


    }

    @Override
    public boolean deleteUserByUsername(String username)  {
        User deleteuser=userRepo.existsByName(username);
//        if(deleteuser.getUsername()!=username){
//            throw new UserNotFoundException("User Not Exists");
//        }
        deleteuser=userRepo.deleteUserByUsername(username);
        return true;
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
        User friend=userRepo.existsByName(username2);
        Long id=loggedInUser.getId();
        friend.friends.remove(id);
        loggedInUser.friends.remove(friend.getId());
        userRepo.save(friend);
        userRepo.save(loggedInUser);
        return loggedInUser;
    }

}
