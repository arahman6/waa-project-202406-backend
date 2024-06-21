package com.example.ecommerce.controller;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.category.Category;
import com.example.ecommerce.entity.category.SubCategory;
import com.example.ecommerce.entity.dto.request.ProductRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.ReviewResponse;
import com.example.ecommerce.entity.product.FilterCriteriaDTO;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.product.filter.*;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends GenericControllerImpl<Product, ProductRequest, ProductResponse, Long> {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){super(productService);}


    @GetMapping("/{id}/reviews")
    public List<ReviewResponse> getProductReviews(@PathVariable Long id) {
        return productService.getProductReviews(id);
    }

    @GetMapping("/filter")
    public List<ProductResponse> getFilteredProducts(
            @RequestParam(required = false) List<Category> categories,
            @RequestParam(required = false) List<SubCategory> subCategories,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) List<Brand> brands,
            @RequestParam(required = false) List<Rating> ratings,
            @RequestParam(required = false) List<Color> colors,
            @RequestParam(required = false) List<Size> sizes,
            @RequestParam(required = false) List<Material> materials,
            @RequestParam(required = false) Boolean inStock,
            @RequestParam(required = false) Boolean onSale,
            @RequestParam(required = false) Boolean newArrival) {

        return productService.getFilteredProducts(categories, subCategories, minPrice, maxPrice, brands, ratings, colors, sizes, materials, inStock, onSale, newArrival);
    }

    @GetMapping("/filter-criteria")
    public FilterCriteriaDTO getFilterCriteria() {
        return productService.getFilterCriteria();
    }


}

