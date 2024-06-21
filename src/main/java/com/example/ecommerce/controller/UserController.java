package com.example.ecommerce.controller;


import com.example.ecommerce.entity.dto.request.OrderStatusRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.Role;

import com.example.ecommerce.controller.generic.GenericControllerImpl;
import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.UserResponse;

import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends GenericControllerImpl<User, UserRequest, UserResponse, Long> {
    @Autowired
    UserService userService;


    public UserController(UserService userService){
        super(userService);
    }

    @Override
    public User create(@Valid UserRequest userRequest) {
        return userService.create(userRequest);
    }


    @GetMapping("/email/{emailId}")
    public UserResponse getUserById(@PathVariable String emailId) {
        return userService.getUserByEmail(emailId);
    }


    //user specific
    // todo: Add User specific stuff

//    @PostMapping("/{id}/cart")
//    //@PreAuthorize("hasRole('USER')")
//    public Cart addToCart(@PathVariable Long id, @RequestBody List<Item> items) {
//        return userService.addToCart(id, items);
//    }

//    @GetMapping("/{id}/cart")
//   // @PreAuthorize("hasRole('USER')")
//    public Cart getCart(@PathVariable Long id) {
//        return userService.getCart(id);
//    }

    @DeleteMapping("/{id}/cart")
    //@PreAuthorize("hasRole('USER')")
    public void clearCart(@PathVariable Long id,List<Long>ids) {
        userService.clearCart(id,ids);
    }

//    @PostMapping("/{id}/orders")
//    //@PreAuthorize("hasRole('USER')")
//    public Order createOrder(@PathVariable Long id,@RequestBody List<Item>items) {
//        return userService.createOrder(id,items);
//    }

//    @GetMapping("/{id}/orders")
//    //@PreAuthorize("hasRole('USER')")
//    public List<Order> getOrders(@PathVariable Long id) {
//        return userService.getOrders(id);
//    }

//    @PutMapping("/{id}/orders/{orderId}")
//    //@PreAuthorize("hasRole('USER')")
//    public Order cancelOrder(@PathVariable Long id, @PathVariable Long orderId, @RequestBody @Valid OrderStatusRequest orderStatus) {
//        return userService.cancelOrder(id,orderId,orderStatus);
//    }

//    @PostMapping("/{id}/products/{productId}/reviews")
//    //@PreAuthorize("hasRole('USER')")
//    public Review addReview(@PathVariable Long id, @PathVariable Long productId, @RequestBody String review) {
//        return userService.addReview(id,productId,review);
//    }


//    //Seller Specific
//    //todo: Add seller specific
//
//    @PutMapping("/{id}/approve-request")
//    //@PreAuthorize("hasRole('SELLER')")
//    public UserResponse approveSeller(@PathVariable Long id) {
//        return userService.approveSeller(id);
//    }

}
