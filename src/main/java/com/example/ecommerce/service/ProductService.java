package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.ProductRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService extends GenericService<Product, ProductRequest, ProductResponse, Long> {

}

