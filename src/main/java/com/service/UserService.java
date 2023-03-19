package com.service;

import java.util.Optional;

import com.model.User;

public interface UserService {

    public Iterable<User> getAllUsers();

    public User addUser(User user);

    // delete
    public String deleteUser(String id);

    // update
    public User updateUser(String id, User user);
    
    // user login
    public User login(String email, String password);

    // find by email
    public Optional<User> findByEmail(String email);

    // find by id
    public Optional<User> findById(String id);

    // update booking
    public User updateBooking(String id, String newBooking);
}
