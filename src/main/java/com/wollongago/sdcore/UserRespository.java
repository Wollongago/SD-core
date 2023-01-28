package com.wollongago.sdcore;


import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRespository extends MongoRepository<User, String> {
    // Optional<User> findByUsername(String username);
  
    // Boolean existsByUsername(String name);
  
    // Boolean existsByEmail(String email);
  }