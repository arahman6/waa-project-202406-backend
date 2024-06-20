package com.example.ecommerce.service;

import com.example.ecommerce.entity.product.Product;

public interface SellerService {
    Product addProduct(Long id, Product product);
    boolean deleteProduct(Long sellerId, Long productId);

}
