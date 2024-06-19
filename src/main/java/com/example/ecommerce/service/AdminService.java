package com.example.ecommerce.service;

import com.example.ecommerce.entity.user.AdminUser;
import com.example.ecommerce.entity.user.Role;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.AdminUserRepository;
import com.example.ecommerce.repository.ReviewRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminUserRepository adminUserRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;


    public User approveSeller(Long sellerId) {
        User user = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEnable(true);
        user.setHasRequestedForApproval(false);
        Role role = new Role();
        role.setRole("SELLER");
        user.getRoles().add(role);
        return userRepository.save(user);
    }

    public User rejectSeller(Long sellerId) {
        User user = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEnable(false);
        user.setHasRequestedForApproval(false);

        return userRepository.save(user);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public List<User> getUsersForApproval() {
        return userRepository.findAll()
                .stream()
                .filter(user->user.getHasRequestedForApproval())
                .toList();
    }
}
