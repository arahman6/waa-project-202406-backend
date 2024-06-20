package com.example.ecommerce.entity.payment;

import com.example.ecommerce.entity.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private Order order;

    private String paymentMethod; // e.g., CREDIT_CARD, PAYPAL
    private LocalDateTime paymentDate;
    private Double amount;

    // Getters and Setters
}

