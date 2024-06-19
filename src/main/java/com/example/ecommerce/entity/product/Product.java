package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer stockQuantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Review> review;

    @ManyToOne
    private User user;

    public List<Review> getReviews() {
        return null;
    }
}
