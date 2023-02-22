package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRespository;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRespository userRepo;

    @Autowired
    public void UserService(UserRespository userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }


    // delete
    public String deleteUser(String id) {
        userRepo.deleteById(id);
        return "User Deleted";
    }

    // update
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    // update user information
    public User updateUser(String id, User user) {
        User userToUpdate = userRepo.findById(id).get();
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        return userRepo.save(userToUpdate);
    }

}
