package com.chatapp.chatservice.business.service.impl;

import com.chatapp.chatservice.business.service.UserService;
import com.chatapp.chatservice.persistence.entity.User;
import com.chatapp.chatservice.persistence.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmailOrUserName(String email, String userName) {
        return userRepository.findByEmailOrUsername(email, userName);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
