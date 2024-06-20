package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.product.filter.Rating;
import com.example.ecommerce.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ReviewResponse {
    private Long id;
    private UserResponse user;
    private String comment;
    private Date reviewDate;
    private Rating rating;
}
