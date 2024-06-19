package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.OrderRequest;
import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService extends GenericService<Order, OrderRequest, OrderResponse, Long> {

}
