package com.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.model.User;
@RepositoryRestResource(path="users")
public interface UserRespository extends MongoRepository<User, String> {
    // Optional<User> findByUsername(String username);
  
    // Boolean existsByUsername(String name);
  
    // Boolean existsByEmail(String email);
  }