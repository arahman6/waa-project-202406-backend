package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserRequest, UserResponse, Long> implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(userRepository, modelMapper, listMapper);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
