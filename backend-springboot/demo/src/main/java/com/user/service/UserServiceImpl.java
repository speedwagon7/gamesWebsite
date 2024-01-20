package com.user.service;

import org.springframework.stereotype.Service;

import com.user.exception.ResourceNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Override
    public User createUser( User newUser){
        System.out.println("added new user" + newUser.getUsername());
        User savedUser = this.userRepository.save(newUser);
        return savedUser;
    }

    @Override
    public User getUserById(Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> 
                                        new ResourceNotFoundException("Employee does not exist with given id: " + userId));
        return foundUser;
    }

}
