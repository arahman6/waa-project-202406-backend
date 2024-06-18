package com.example.ecommerce.service;

import com.example.ecommerce.entity.user.User;

import java.util.List;

import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {return userRepository.findByEmail(email);}

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        userRepository.deleteById(id);
        return userRepository.save(userDetails);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

