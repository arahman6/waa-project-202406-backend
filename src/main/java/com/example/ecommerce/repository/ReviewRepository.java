package com.example.ecommerce.repository;

import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends GenericRepository<Review, Long> {
}