package com.example.ecommerce.controller;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.dto.request.OrderRequest;
import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController extends GenericControllerImpl<Order, OrderRequest, OrderResponse, Long> {
    @Autowired
    private OrderService orderService;

   public OrderController(OrderService orderService){super(orderService);}
}

