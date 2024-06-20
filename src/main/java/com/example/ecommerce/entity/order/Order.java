package com.example.ecommerce.entity.order;

import com.example.ecommerce.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "user-orders")
    private User user;

    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Item> orderItems;


    public Long getSellerId(){
        return orderItems.getFirst().getProduct().getUser().getId();
    }
}

