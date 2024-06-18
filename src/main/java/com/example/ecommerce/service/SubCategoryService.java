package com.example.ecommerce.service;

import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.dto.request.SubCategoryRequest;
import com.example.ecommerce.entity.dto.response.SubCategoryResponse;
import com.example.ecommerce.repository.SubCategoryRepository;
import com.example.ecommerce.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SubCategoryService extends GenericService<SubCategory, SubCategoryRequest, SubCategoryResponse, Long> {

}

