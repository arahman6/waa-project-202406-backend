package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.product.filter.Rating;
import com.example.ecommerce.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JsonBackReference(value = "product-review")
    @ToString.Exclude
    private Product product;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String comment;
    private Date reviewDate;

}

