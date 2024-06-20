package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.category.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private List<SubCategoryResponse> subCategories;
}
