package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.ReviewRequest;
import com.example.ecommerce.entity.dto.response.ReviewResponse;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.repository.ReviewRepository;
import com.example.ecommerce.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService extends GenericService<Review, ReviewRequest, ReviewResponse, Long> {

}