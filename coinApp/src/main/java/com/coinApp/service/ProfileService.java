package com.coinApp.service;

import com.coinApp.model.User;
import com.coinApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private UserRepository userRepository;

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
