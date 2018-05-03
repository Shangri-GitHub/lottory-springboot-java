package com.lottery.service;

import com.lottery.entity.User;
import com.lottery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String name) {
        User user = null;
        try {
            user = userRepository.findByUserName(name);
        } catch (Exception e) {
        }
        return user;
    }

}
