package com.example.ecommerce.entity.dto.request;

import com.example.ecommerce.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubCategoryRequest {
    private String name;
    private Category category;
}
