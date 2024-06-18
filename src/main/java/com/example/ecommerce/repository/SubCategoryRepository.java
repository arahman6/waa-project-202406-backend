package com.example.ecommerce.repository;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.repository.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends GenericRepository<SubCategory, Long> {
}

