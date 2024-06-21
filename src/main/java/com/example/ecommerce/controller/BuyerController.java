package com.example.ecommerce.controller;

import com.example.ecommerce.entity.dto.response.CartResponse;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buyer")
//@PreAuthorize("hasRole('BUYER')")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @PostMapping("/{id}/addToCart")
    public void addToCart(@PathVariable Long id, @RequestBody Item item){
        buyerService.addItemToCart(id, item);
    }

    @DeleteMapping("/{id}/cart/deleteItemFromCart/{itemId}")
    public void deleteFromCart(@PathVariable Long id, @PathVariable Long itemId){
        buyerService.removeItemFromCart(id, itemId);
    }

    @PostMapping("/{id}/cart/makeOrder")
    public void makeOrder(@PathVariable Long id, @RequestBody List<Item> items){
        buyerService.makeOrder(id, items);
    }

    @PutMapping("/{id}/orders/cancelOrder/{orderId}")
    public void cancelOrder(@PathVariable Long orderId){
        buyerService.cancelOrder(orderId);
    }

    @GetMapping("/{id}/cart")
    public CartResponse getCart(@PathVariable Long id){
        return buyerService.getCart(id);
    }

    @GetMapping("/{id}/orders")
    public List<OrderResponse> getOrders(@PathVariable Long id){
        return buyerService.getOrders(id);
    }

    @PostMapping("/{id}/products/{productId}/addReview")
    public void addReview(@PathVariable Long id, @PathVariable Long productId, @RequestBody Review review){
        buyerService.addReview(id, productId, review);
    }

    @PutMapping("/{id}/products/{productId}/updateReview/{reviewId}")
    public void updateReview(@PathVariable Long id, @PathVariable Long reviewId, @RequestBody Review review){
        buyerService.updateReview(id, reviewId, review);
    }

    @DeleteMapping("/{id}/products/{productId}/deleteReview/{reviewId}")
    public void deleteReview(@PathVariable Long id, @PathVariable Long reviewId){
        buyerService.deleteReview(id, reviewId);
    }

}
