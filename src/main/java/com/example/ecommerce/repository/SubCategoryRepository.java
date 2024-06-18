package com.example.ecommerce.repository;
import com.example.ecommerce.entity.category.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}

