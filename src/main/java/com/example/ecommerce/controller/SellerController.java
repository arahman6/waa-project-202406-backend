package com.example.ecommerce.controller;

import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/{id}/add-product")
    public Product addProduct(@PathVariable Long id, @RequestBody Product product){
        return sellerService.addProduct(id, product);
    }

    @DeleteMapping("/{id}/delete-product/{productId}")
    public boolean deleteProduct(@PathVariable Long id, @PathVariable Long productId){
        return sellerService.deleteProduct(id, productId);
    }
}
