package com.user.service;

import com.user.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long Id);
}
