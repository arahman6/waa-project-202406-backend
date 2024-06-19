package com.example.ecommerce.controller;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.dto.request.CategoryRequest;
import com.example.ecommerce.entity.dto.response.CategoryResponse;
import com.example.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends GenericControllerImpl<Category, CategoryRequest, CategoryResponse, Long> {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        super(categoryService);
    }

}

