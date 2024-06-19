package com.example.ecommerce.service;

import com.example.ecommerce.entity.user.AdminUser;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.AdminUserRepository;
import com.example.ecommerce.repository.ReviewRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminUserRepository adminUserRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    public AdminUser createAdmin(AdminUser admin) {
       return adminUserRepository.save(admin);
    }

    public User approveSeller(Integer sellerId) {
        User user = userRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEnable(true);
        return userRepository.save(user);

    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
