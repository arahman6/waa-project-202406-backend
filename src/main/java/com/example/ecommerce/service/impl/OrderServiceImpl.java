package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.dto.request.OrderRequest;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.EmailService;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, OrderRequest, OrderResponse, Long> implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(orderRepository, modelMapper, listMapper);
    }

}
