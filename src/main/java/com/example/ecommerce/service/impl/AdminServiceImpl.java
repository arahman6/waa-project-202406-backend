package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.user.Role;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.AdminUserRepository;
import com.example.ecommerce.repository.ReviewRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminUserRepository adminUserRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public User approveSeller(Long sellerId) {
        User user = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEnable(true);
        user.setHasRequestedForApproval(false);
        Role role = new Role();
        role.setRole("SELLER");
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    @Override
    public User rejectSeller(Long sellerId) {
        User user = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEnable(false);
        user.setHasRequestedForApproval(false);

        return userRepository.save(user);
    }

    @Override
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public List<User> getUsersForApproval() {
        return userRepository.findAll()
                .stream()
                .filter(user->user.getHasRequestedForApproval())
                .toList();
    }
}
