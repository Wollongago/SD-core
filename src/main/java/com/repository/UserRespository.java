package com.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.User;
public interface UserRespository extends MongoRepository<User, String> {
    // Optional<User> findByUsername(String username);
  
    // Boolean existsByUsername(String name);
  
    // Boolean existsByEmail(String email);
  }