package com.stackroute.fullstackbackend.repository;

import com.stackroute.fullstackbackend.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends Neo4jRepository<User,Long> {

    @Query("MATCH (me:User)-[:friend]->(myFriend:User)-[:friend]->(friendOfFriend:User) WHERE NOT \n" +
            "(me)-[:friend]->(friendOfFriend:User) AND me.name = {name} AND NOT friendOfFriend.name={name}\n" +
            "RETURN \n" +
            " friendOfFriend")
    public List<User> recommendL1(@Param("name") String name);

    @Query("MATCH (me:User)-[:friend]->(myFriend:User)-[:friend]->(friendOfFriend:User)-[:friend]->(friendOfFriendOfFriend:User) WHERE NOT \n" +
            "(me)-[:friend]->(friendOfFriendOfFriend:User) AND NOT (me)-[:friend]->(friendOfFriend:User) AND me.name = {name} AND NOT friendOfFriendOfFriend.name={name}\n" +
            "RETURN \n" +
            " friendOfFriendOfFriend")
    public List<User> recommendL2(@Param("name") String name);


    @Query("MATCH (a:User), (b:User) WHERE a.name ={userName1} AND b.name ={userName2} CREATE (a)-[r: friend]->(b) CREATE (a)<-[f: friend]-(b) RETURN a,b ")
    public List<User> makeFriend(@Param("userName1") String userName1,@Param("userName2") String userName2);
    @Query("MATCH(n) RETURN n")
    public List<User> getAllUsers();
    public User getByName(String name);
}

