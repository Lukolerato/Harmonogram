package com.ConfHandler.HarmDemo.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ConfHandler.HarmDemo.model.User;
import com.ConfHandler.HarmDemo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000") // Zezwolenie na CORS dla React
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
        return authenticatedUser.isPresent() ? "SUCCESS" : "FAILURE";
    }
}
