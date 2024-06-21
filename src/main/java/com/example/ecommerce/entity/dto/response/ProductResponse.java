package com.example.ecommerce.entity.dto.response;


import com.example.ecommerce.entity.product.filter.Brand;
import com.example.ecommerce.entity.product.filter.Color;
import com.example.ecommerce.entity.product.filter.Material;
import com.example.ecommerce.entity.product.filter.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer stockQuantity;
    private Brand brand;
    private Color color;
    private Size size;
    private Material material;
    private SubCategoryResponse subCategory;
    private List<ReviewResponse> review;

}
