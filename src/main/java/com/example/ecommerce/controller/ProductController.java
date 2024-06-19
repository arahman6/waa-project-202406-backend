package com.example.ecommerce.controller;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.dto.request.ProductRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends GenericControllerImpl<Product, ProductRequest, ProductResponse, Long> {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){super(productService);}


    @GetMapping("/{id}/reviews")
    public List<Review> getProductReviews(@PathVariable Long id) {

        return productService.getProductReviews(id);
    }


}

