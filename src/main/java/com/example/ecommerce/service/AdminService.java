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


public interface AdminService {

    User approveSeller(Long sellerId);
    User rejectSeller(Long sellerId);
    void deleteReview(Long reviewId);
    List<User> getUsersForApproval();

}
