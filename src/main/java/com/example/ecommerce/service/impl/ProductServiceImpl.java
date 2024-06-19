package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.dto.request.ProductRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductRequest, ProductResponse, Long> implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(productRepository, modelMapper, listMapper);
    }

    @Override
    public List<Review> getProductReviews(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return product.getReviews();
        }
        return List.of();
    }
}
