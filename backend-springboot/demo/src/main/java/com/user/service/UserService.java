package com.user.service;

import java.util.List;

import com.user.dto.UserDto;
import com.user.model.User;

public interface UserService {
    User createUser(UserDto userDto);
    User findUserByEmail(String email);
    User findUserById(Long Id);
    List<User> getAllUsers();
    void deleteUserById(Long Id);
}
