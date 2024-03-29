package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.model.User;

@RepositoryRestResource(path = "users")
public interface UserRespository extends MongoRepository<User, String> {
    // Optional<User> findByUsername(String username);
    @Query(value = "{}", fields = "{'password':0}")
    List<User> findAll();
    
    // query by email
    Optional<User> findByEmail(String email);

    //find by id
    Optional<User> findById(String id);
  }

