package com.example.ecommerce.service;


import com.example.ecommerce.controller.ProductController;
import com.example.ecommerce.entity.dto.request.OrderStatusRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.Role;

import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.UserResponse;

import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.generic.GenericService;

import java.util.List;



//    public User createUser(User user) {
//        Role role = new Role();
//        role.setUser(user);
//        role.setRole("USER");
//        List<Role> roles = user.getRoles();
//        if (roles == null) {
//            roles = new ArrayList<>();
//        }
//        roles.add(role);
//        user.setRoles(roles);
//
//        return userRepository.save(user);
//    }

public interface UserService extends GenericService<User, UserRequest, UserResponse, Long> {
    UserResponse getUserByEmail(String email);
    UserResponse addRoles(Long id, Role role);
    Cart addToCart(Long id, List<Item> items);
    Cart getCart(Long id);
    public Order createOrder(Long id, List<Item> items);
    void clearCart(Long userId, List<Long> itemIds);
    List<ProductResponse> addProducts(Long id, List<Product> products);
    ProductResponse updateProduct(Long userId,Long productId, Product productDetails);
    List<ProductResponse> getProducts(Long id);
    List<Order> getOrders(Long id);
    List<ProductResponse> getOrderedProducts(Long userId);
    List<Order> getOrdersBySeller(Long id);
    Order updateOrderStatus(Long id, Long orderId, OrderStatusRequest orderStatus);
    Order cancelOrder(Long id, Long orderId, OrderStatusRequest orderStatus);
    Review addReview(Long id, Long productId, String review);
    UserResponse approveSeller(Long id);
    User create(UserRequest userRequest);
}
