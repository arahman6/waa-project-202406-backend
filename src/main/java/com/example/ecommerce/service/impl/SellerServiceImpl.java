package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product addProduct(Long id, Product product) {
        User seller = userRepository.findById(id).orElse(null);
        if(seller != null){
            product.setUser(seller);
            Product savedProduct = productRepository.save(product);
            seller.addProduct(savedProduct);
            userRepository.save(seller);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long sellerId, Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        User seller = userRepository.findById(sellerId).orElse(null);
        if(seller != null && product != null && product.isPurchased()==false) {
            seller.removeProduct(product);
            userRepository.save(seller);
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
