package com.example.ecommerce.repository;

import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends GenericRepository<Product, Long> {
}

