package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.dto.request.CategoryRequest;
import com.example.ecommerce.entity.dto.response.CategoryResponse;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryRequest, CategoryResponse, Long> implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(categoryRepository, modelMapper, listMapper);
    }

}
