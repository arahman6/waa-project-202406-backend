package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String comment;
    private Date reviewDate;

}

