package com.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.dto.UserDto;
import com.user.exception.ResourceNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser( UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        //encrypt password with spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        System.out.println("added new user" + userDto.getUsername());
        User savedUser = this.userRepository.save(user);
        return savedUser;
    }
    @Override
    public User findUserById(Long Id) {
        User foundUser = userRepository.findById(Id).orElseThrow(() -> 
                                        new ResourceNotFoundException("Employee does not exist with given Id: " + Id));
        return foundUser;
    }
    @Override
    public User findUserByEmail(String email) {
        User foundUser = userRepository.findByEmail(email).orElseThrow(() -> 
                                        new ResourceNotFoundException("Employee does not exist with given email: " + email));
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
