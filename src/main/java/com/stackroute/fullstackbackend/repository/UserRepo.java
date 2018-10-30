package com.stackroute.fullstackbackend.repository;

import com.stackroute.fullstackbackend.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepo extends Neo4jRepository<User,Long> {

    @Query("create(n:friends)")
    public User addFriend(User user);
    @Query("create (n:User)-[:friend]->(n:friends)")
    public User makeFriend();
    @Query("match (n) return n")
    public List<User> getAllUsers();
    public User getByName(String name);
}
