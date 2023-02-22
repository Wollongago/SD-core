package com.service;
import com.model.User;

public interface UserService {
    
    public Iterable<User> getAllUsers();

    public User addUser(User user);

    // delete
    public String deleteUser(String id);

    // update
    public User updateUser(User user);
}
