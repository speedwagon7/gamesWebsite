package com.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/login/{id}")
    public User findUserById(@RequestParam Long Id) {
        return userRepository.getReferenceById(Id);
    }
    
    @PostMapping("/registerUser")
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        System.out.println("testing");
        try {
            // Validate and save the user
            User savedUser = userRepository.save(newUser);
    
            // Return a ResponseEntity with the saved user and HTTP status CREATED
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
}
