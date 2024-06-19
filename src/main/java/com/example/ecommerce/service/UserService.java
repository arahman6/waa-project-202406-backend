package com.example.ecommerce.service;


import com.example.ecommerce.controller.ProductController;
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
    User getUserByEmail(String email);
    User addRoles(Long id, Role role);
    Cart addToCart(Long id, List<Item> items);
    Cart getCart(Long id);
    public Order createOrder(Long id, List<Item> items);
    void clearCart(Long userId, List<Long> itemIds);
    void addProducts(Long id, List<Product> products);
    Product updateProduct(Long userId,Long productId, Product productDetails);
    List<Product> getProducts(Long id);
    List<Order> getOrders(Long id);
    List<Product> getOrderedProducts(Long userId);
    List<Order> getOrdersBySeller(Long id);
    Order updateOrderStatus(Long id, Long orderId, OrderStatus orderStatus);
    Order cancelOrder(Long id, Long orderId, OrderStatus orderStatus);
    Product addReview(Long id, Long productId, String review);
    User approveSeller(Long id);
}
