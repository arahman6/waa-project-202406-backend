package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.dto.request.SubCategoryRequest;
import com.example.ecommerce.entity.dto.response.SubCategoryResponse;
import com.example.ecommerce.repository.SubCategoryRepository;
import com.example.ecommerce.service.SubCategoryService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryServiceImpl extends GenericServiceImpl<SubCategory, SubCategoryRequest, SubCategoryResponse, Long> implements SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(subCategoryRepository, modelMapper, listMapper);
    }
}
