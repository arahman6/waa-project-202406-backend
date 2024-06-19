package com.example.ecommerce.repository;

import com.example.ecommerce.entity.product.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}