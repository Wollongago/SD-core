package com.service;
import com.model.User;

public interface UserService {
    
    public Iterable<User> getAllUsers();

    public User addUser(User user);

    // delete
    public String deleteUser(String id);

    // update
    public User updateUser(String id, User user);

    // find by email
    public User findByEmail(String email);
}
