package com.example.ecommerce.repository;

import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends GenericRepository<User, Long> {

    User findByEmail(String email);
}
