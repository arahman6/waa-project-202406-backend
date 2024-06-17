package com.example.ecommerce.entity.payment;

import com.example.ecommerce.entity.order.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    private String paymentMethod; // e.g., CREDIT_CARD, PAYPAL
    private LocalDateTime paymentDate;
    private Double amount;

    // Getters and Setters
}

