package com.controller;

import java.util.List;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.repository.UserRespository;

@RestController
public class UserController {
    @Autowired
    private UserRespository userRepo;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user ) {
        return userRepo.save(user);
    }

    @GetMapping("/")
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
