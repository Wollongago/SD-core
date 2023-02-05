package com.controller;

import java.util.List;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.UserService;

@Controller
public class UserThymeleafController {
    
    private UserService userService;

    @Autowired
    public UserThymeleafController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allusers") 
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping({"/home","/"})
    public String home(Model model) {
        model.addAttribute("pageTitle", "Home");
        return "home";
    }

    @GetMapping({"/signup"})
    public String signUp(Model model) {
        model.addAttribute("pageTitle", "Sign Up");
        return "signup";
    }
}
