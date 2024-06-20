package com.example.ecommerce.controller;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.dto.request.ReviewRequest;
import com.example.ecommerce.entity.dto.response.ReviewResponse;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController extends GenericControllerImpl<Review, ReviewRequest, ReviewResponse,Long> {
    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        super(reviewService);
    }

    @Override
    @DeleteMapping("/{reviewId}")
    //@PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long reviewId) {
         reviewService.deleteById(reviewId);
    }
}
