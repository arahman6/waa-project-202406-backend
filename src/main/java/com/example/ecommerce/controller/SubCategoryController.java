package com.example.ecommerce.controller;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.dto.request.SubCategoryRequest;
import com.example.ecommerce.entity.dto.response.SubCategoryResponse;
import com.example.ecommerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategories")
public class SubCategoryController extends GenericControllerImpl<SubCategory, SubCategoryRequest, SubCategoryResponse, Long> {
    @Autowired
    private SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService){
        super(subCategoryService);
    }
}

