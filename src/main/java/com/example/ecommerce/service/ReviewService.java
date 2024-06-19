package com.example.ecommerce.service;

import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setUser(reviewDetails.getUser());
            review.setProduct(reviewDetails.getProduct());
            review.setRating(reviewDetails.getRating());
            review.setComment(reviewDetails.getComment());
            review.setReviewDate(reviewDetails.getReviewDate());
            return reviewRepository.save(review);
        }
        return null;
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}