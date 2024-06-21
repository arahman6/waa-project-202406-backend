package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {
    private Long id;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private double price;
    private OrderStatus status;
    private List<ItemResponse> orderItems;
}
