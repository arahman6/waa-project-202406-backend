package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.ProductRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.ReviewResponse;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;

import com.example.ecommerce.service.generic.GenericService;
import java.util.List;


public interface ProductService extends GenericService<Product, ProductRequest, ProductResponse, Long> {



//    public Product updateProduct(Long id, Product productDetails) {
//        Product product = productRepository.findById(id).orElse(null);
//        if (product != null) {
//            product.setName(productDetails.getName());
//            product.setDescription(productDetails.getDescription());
//            product.setPrice(productDetails.getPrice());
//            product.setImageUrl(productDetails.getImageUrl());
//            product.setStockQuantity(productDetails.getStockQuantity());
//            product.setSubCategory(productDetails.getSubCategory());
//            return productRepository.save(product);
//        }
//        return null;
//    }

    List<ReviewResponse> getProductReviews(Long id);


}

