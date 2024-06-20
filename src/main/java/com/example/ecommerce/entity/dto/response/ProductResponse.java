package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer stockQuantity;
    private SubCategory subCategory;
    private List<Review> review;
}
