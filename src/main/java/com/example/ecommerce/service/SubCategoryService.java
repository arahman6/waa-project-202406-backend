package com.example.ecommerce.service;

import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory updateSubCategory(Long id, SubCategory subCategoryDetails) {
        subCategoryRepository.findById(id);
        return subCategoryRepository.save(subCategoryDetails);
    }

    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }
}

