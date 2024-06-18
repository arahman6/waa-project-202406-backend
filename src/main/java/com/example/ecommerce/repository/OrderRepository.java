package com.example.ecommerce.repository;

import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends GenericRepository<Order, Long> {
}

