package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.response.CartResponse;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Review;

import java.util.List;

public interface BuyerService {
    void addItemToCart(Long buyId, Item item);
    void removeItemFromCart(Long buyId,Long itemId);
    void makeOrder(Long buyId,List<Item> items);
    void cancelOrder(Long id);
    CartResponse getCart(Long id);
    List<OrderResponse> getOrders(Long id);
    void addReview(Long id, Long ProductId, Review review);
    void updateReview(Long id, Long reviewId, Review review);
    void deleteReview(Long id, Long reviewId);
}
