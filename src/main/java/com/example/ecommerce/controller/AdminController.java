package com.example.ecommerce.controller;

import com.example.ecommerce.entity.user.AdminUser;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private  final AdminService adminService;


    @PutMapping("approve/{sellerId}")
    public User approveSeller(@PathVariable Integer sellerId) {
        return adminService.approveSeller(sellerId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        adminService.deleteReview(reviewId);
    }
}
