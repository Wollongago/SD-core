package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }   

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody Map<String, Object> userData) {
        User user = new User();
        user.setId(id);
        user.setName((String) userData.get("name"));
        user.setEmail((String) userData.get("email"));
        return userService.updateUser(id, user);
    }

    // user login endpoint
    @PostMapping("/login")
    public User login(@RequestBody Map<String, Object> userData) {
        String email = (String) userData.get("email");
        String password = (String) userData.get("password");
        return userService.login(email, password);
    }

}
