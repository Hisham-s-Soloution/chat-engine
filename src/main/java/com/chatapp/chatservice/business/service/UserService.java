package com.chatapp.chatservice.business.service;

import com.chatapp.chatservice.persistence.entity.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> getUserByUsername(String username);
    Optional<User> findByEmailOrUserName(String email, String userName);
}
