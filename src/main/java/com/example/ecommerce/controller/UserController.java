package com.example.ecommerce.controller;

import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.user.Role;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


    //user specific
    // todo: Add User specific stuff

    @PostMapping("/{id}/cart")
    //@PreAuthorize("hasRole('USER')")
    public Cart addToCart(@PathVariable Integer id, @RequestBody List<Item> items) {
        return userService.addToCart(id, items);
    }

    @GetMapping("/{id}/cart")
   // @PreAuthorize("hasRole('USER')")
    public Cart getCart(@PathVariable Integer id) {
        return userService.getCart(id);
    }

    @DeleteMapping("/{id}/cart")
    //@PreAuthorize("hasRole('USER')")
    public void clearCart(@PathVariable Integer id,List<Long>ids) {
        userService.clearCart(id,ids);
    }

    @PostMapping("/{id}/orders")
    //@PreAuthorize("hasRole('USER')")
    public Order createOrder(@PathVariable Integer id,@RequestBody List<Item>items) {
        return userService.createOrder(id,items);
    }

    @GetMapping("/{id}/orders")
    //@PreAuthorize("hasRole('USER')")
    public List<Order> getOrders(@PathVariable Integer id) {
        return userService.getOrders(id);
    }

    @PutMapping("/{id}/orders/{orderId}")
    //@PreAuthorize("hasRole('USER')")
    public Order cancelOrder(@PathVariable Integer id, @PathVariable Long orderId, @RequestBody OrderStatus orderStatus) {
        return userService.cancelOrder(id,orderId,orderStatus);
    }

    @PostMapping("/{id}/products/{productId}/reviews")
    //@PreAuthorize("hasRole('USER')")
    public Product addReview(@PathVariable Integer id, @PathVariable Long productId, @RequestBody String review) {
        return userService.addReview(id,productId,review);
    }


    //Seller Specific
    //todo: Add seller specific

    @PutMapping("/{id}/approve-request")
    //@PreAuthorize("hasRole('SELLER')")
    public User approveSeller(@PathVariable Integer id) {
        return userService.approveSeller(id);
    }


    @PostMapping("/{id}/products")
    //@PreAuthorize("hasRole('SELLER')")
    public void addProducts(@PathVariable Integer id,@RequestBody List<Product>products) {
        userService.addProducts(id,products);
    }

    @PutMapping("{id}/products/{productId}")
    //@PreAuthorize("hasRole('SELLER')")
    public Product updateProduct(@PathVariable Integer id, @PathVariable Long productId,@RequestBody Product productDetails) {
        return userService.updateProduct(id,productId,productDetails);
    }

    @GetMapping("/{id}/products")
    //@PreAuthorize("hasRole('SELLER')")
    public List<Product> getProducts(@PathVariable Integer id) {
        return userService.getProducts(id);
    }

    //Maintaining orders
    //getAllOrders
    @GetMapping("/{id}/ordered")
    //@PreAuthorize("hasRole('SELLER')")
    public List<Order> getOrdersBySeller(@PathVariable Integer id) {
        return userService.getOrdersBySeller(id);
    }


    @GetMapping("/{id}/ordered-products")
    //@PreAuthorize("hasRole('SELLER')")
    public List<Product> getOrderedProducts(@PathVariable Integer id) {
        return userService.getOrderedProducts(id);
    }


    @PutMapping("/{id}/ordered-products/{orderId}")
    //@PreAuthorize("hasRole('SELLER')")
    public Order updateOrderStatus(@PathVariable Integer id, @PathVariable Long orderId, @RequestBody OrderStatus orderStatus) {
        return userService.updateOrderStatus(id,orderId,orderStatus);
    }







}


