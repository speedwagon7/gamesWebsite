package com.user.service;

import java.util.List;

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

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public void deleteUserById(Long Id) throws ResourceNotFoundException {
        userRepository.deleteById(Id);
    }

}
