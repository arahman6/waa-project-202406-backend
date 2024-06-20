package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubCategoryResponse {
    private Long id;
    private String name;
}
