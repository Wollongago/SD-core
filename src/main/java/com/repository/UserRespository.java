package com.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.model.User;

@RepositoryRestResource(path="users")
public interface UserRespository extends MongoRepository<User, String> {
    // Optional<User> findByUsername(String username);
    @Query(value = "{}", fields = "{'password':0}")
    List<User> findAll();
    
    // query by email
    @Query(value = "{'email':?0}", fields = "{'password':0}")
    User findByEmail(String email);
  }