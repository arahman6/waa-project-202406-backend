package com.example.ecommerce.entity.product;

import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.product.filter.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
public class ProductFilterDTO {


    private List<Category> categories;
    private List<SubCategory> subCategories;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private List<Brand> brands;
    private List<Rating> ratings;
    private List<Color> colors;
    private List<Size> sizes;
    private List<Material> materials;
    private boolean inStock;
    private boolean onSale;
    private boolean newArrival;

}

