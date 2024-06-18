package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.generic.GenericService;

public interface UserService extends GenericService<User, UserRequest, UserResponse, Long> {
}
