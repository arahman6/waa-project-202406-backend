package com.example.ecommerce.repository;

import com.example.ecommerce.entity.user.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long> {
}
