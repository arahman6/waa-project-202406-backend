//package com.example.ecommerce.service.impl;
//
//import com.example.ecommerce.entity.user.User;
//import com.example.ecommerce.repository.UserRepository;
//import com.example.ecommerce.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl extends UserService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getUserById(Integer id) {
//        return userRepository.findById(id)
//                .orElse(null);
//    }
//
//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//
//}
