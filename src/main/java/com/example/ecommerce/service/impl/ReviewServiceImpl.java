package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.dto.request.ReviewRequest;
import com.example.ecommerce.entity.dto.response.ReviewResponse;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.repository.ReviewRepository;
import com.example.ecommerce.service.ReviewService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends GenericServiceImpl<Review, ReviewRequest, ReviewResponse, Long> implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(reviewRepository, modelMapper, listMapper);
    }
}
