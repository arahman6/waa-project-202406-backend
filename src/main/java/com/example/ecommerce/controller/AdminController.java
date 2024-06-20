package com.example.ecommerce.controller;

import com.example.ecommerce.entity.user.AdminUser;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private  final AdminService adminService;


    @PutMapping("/approve/{sellerId}")
    public User approveSeller(@PathVariable Long sellerId) {
        return adminService.approveSeller(sellerId);
    }

    @PutMapping("/reject/{sellerId}")
    public User rejectSeller(@PathVariable Long sellerId) {
        return adminService.rejectSeller(sellerId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        adminService.deleteReview(reviewId);
    }

    @GetMapping("/approve/users")
    public List<User> getUsersForApproval() {
        return adminService.getUsersForApproval();
    }
}
