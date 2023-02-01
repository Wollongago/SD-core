package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRespository;

@Service
public class UserService {
    
    private UserRespository userRepo;

    @Autowired
    public UserService(UserRespository userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }
}
