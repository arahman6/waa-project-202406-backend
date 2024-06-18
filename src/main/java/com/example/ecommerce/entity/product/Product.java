package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.category.SubCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer stockQuantity;

    @ManyToOne
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product")
    private List<Review> review;
}
