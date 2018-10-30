package com.stackroute.fullstackbackend.repository;

import com.stackroute.fullstackbackend.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends Neo4jRepository<User,Long> {
    @Query("MATCH (a:User), (b:User) WHERE a.name ={userName1} AND b.name ={userName2} CREATE (a)-[r: friend]->(b) CREATE (a)<-[f: friend]-(b) RETURN a,b ")
    public List<User> makeFriend(@Param("userName1") String userName1,@Param("userName2") String userName2);

    @Query("MATCH(n) RETURN n")
    public List<User> getAllUsers();

    @Query("MATCH(user:User{name:{username}}) detach delete user")
    public boolean deleteUser(@Param("username") String username);

    @Query("MATCH(user:User)<-[r:friend]->(friend:User) where friend.name={username} delete r")
    public boolean deleteUserfriendsByName(@Param("username") String username);

    @Query("MATCH(user:User)-[r:friend]->(friend:User) where user.name={username} return friend")
    public List<User> getUserFriends(@Param("username")String username);
//
//    @Query("match(user:User)-[r:friend]->(f:user)-[r1:friend]->(fof:User) return fof")
//    public List<User>  getLevel2Friends(@Param("username") String username);

}
