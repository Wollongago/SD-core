package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return userRepo.existsById(id) ? "User deletion failed" : "User Deleted";
        } else {
            return "User Not Found";
        }
    }

    // update
    // public User updateUser(User user) {
    // return userRepo.save(user);
    // }

    // update user information
    public User updateUser(String id, User user) {
        if (userRepo.existsById(id)) {
            User userToUpdate = userRepo.findById(id).get();
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            return userRepo.save(userToUpdate);
        } else {
            return null;
        }
    }

    // user login
    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    //find by email
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    // find by id
    public Optional<User> findById(String id) {
        return userRepo.findById(id);

    }

    // update booking of user
    public User updateBooking(String id, String newBooking) {
        if (userRepo.existsById(id)) {
            User userToUpdate = userRepo.findById(id).get();
            if (userToUpdate.getBookings() == null) {
                userToUpdate.setBookings( new ArrayList<String>());
              }
            userToUpdate.getBookings().add(newBooking);
            return userRepo.save(userToUpdate);
        } else {
            return null;
        }
    }

}
