package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private boolean purchased;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference(value = "product-subCategory")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "product-review")
    private List<Review> review;

    @ManyToOne
    @JsonBackReference(value = "user-products")
    private User user;

    public void addReview(Review review1){review.add(review1);}
    public void removeReview(Review review1){review.remove(review1);}

}
