package com.example.ecommerce.service;

import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.dto.request.CategoryRequest;
import com.example.ecommerce.entity.dto.response.CategoryResponse;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService extends GenericService<Category, CategoryRequest, CategoryResponse, Long> {

}

