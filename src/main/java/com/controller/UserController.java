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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    public User login(@RequestBody Map<String, Object> userData) throws Exception {
        String email = (String) userData.get("email");
        String password = (String) userData.get("password");

        if (email == null || password == null) {
            throw new Exception("Email and password fields cannot be empty");
        }

        return userService.login(email, password);
    }

    // logout endpoint
    @PostMapping("/logout")
    public ResponseEntity logout() {
        // do nothing for now - just return a response
        return ResponseEntity.ok("User logged out successfully");
    }

    // create user registration endpoint
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, Object> userData) {
        // check if user exists with same email
        User userExists = userService.findByEmail((String) userData.get("email"));
        // check if all fields are filled
        if (userData.get("name") == null || userData.get("email") == null || userData.get("password") == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please fill all fields");
        }
        // return null if user exists
        if (userExists != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
        User user = new User();
        user.setName((String) userData.get("name"));
        user.setEmail((String) userData.get("email"));
        user.setPassword((String) userData.get("password"));
        userService.addUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

}
