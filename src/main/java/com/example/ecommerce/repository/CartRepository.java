package com.example.ecommerce.repository;

import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends GenericRepository<Cart, Long> {
}
