package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long Id);
    List<User> getAllUsers();
    void deleteUserById(Long Id);
}
