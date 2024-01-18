package com.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/login/{id}")
    public User findUserById(@RequestParam Long Id) {
        return userRepository.getReferenceById(Id);
    }
    
    @PostMapping("/addUser")
    public User addUser(@RequestBody User newUser) {     
        return userRepository.save(newUser);
    }
    
    
    
}
