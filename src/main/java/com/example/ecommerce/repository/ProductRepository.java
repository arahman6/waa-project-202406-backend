package com.example.ecommerce.repository;

import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends GenericRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}

