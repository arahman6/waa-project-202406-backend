package com.example.ecommerce.entity.dto.request;

import com.example.ecommerce.entity.category.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {
    private String name;
    private List<SubCategory> subCategories;
}
