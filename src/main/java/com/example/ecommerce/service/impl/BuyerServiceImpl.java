package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.*;
import com.example.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void addItemToCart(Long buyId, Item item) {
        int qt = item.getQuantity();
        double productPrice = item.getProduct().getPrice();
        item.setPrice(qt*productPrice);
        User buyer = userRepository.findById(buyId).orElse(null);
        if(buyer != null){
            Cart cart = buyer.getCart();
            if(cart == null){
                cart = new Cart();
                cart.setUser(buyer);
                cart.setCartItems(new ArrayList<>());
                buyer.setCart(cart);
                userRepository.save(buyer);
            }
            Item savedItem = itemRepository.save(item);
            cart.addItem(savedItem);
            cartRepository.save(cart);
        }
    }

    @Override
    public void removeItemFromCart(Long buyId, Long itemId) {
        User buyer = userRepository.findById(buyId).orElse(null);
        Item item = itemRepository.findById(itemId).orElse(null);
        if(buyer != null && item != null){
            Cart cart = buyer.getCart();
            cart.removeItem(item);
            cartRepository.save(cart);
            itemRepository.deleteById(itemId);
        }
    }

    @Override
    public void makeOrder(Long buyId, List<Item> items) {
        User buyer = userRepository.findById(buyId).orElse(null);
        if(buyer != null){
            Map<Long, List<Item>> itemsBySeller = items.stream()
                    .collect(Collectors.groupingBy(item ->item.getProduct().getUser().getId()));
            Cart cart = buyer.getCart();
            for (Map.Entry<Long, List<Item>> entry : itemsBySeller.entrySet()) {
                Long sellerId = entry.getKey();
                List<Item> sellerItems = entry.getValue();

                Order order = new Order();
                order.setUser(buyer);
                order.setOrderItems(sellerItems);
                order.setStatus(OrderStatus.PROCESSING);

                double orderPrice =0;
                for (Item item : sellerItems) {
                    cart.removeItem(item);
                    orderPrice+= item.getPrice();
                }
                order.setPrice(orderPrice);
                Order savedOrder= orderRepository.save(order);
                buyer.addOrder(savedOrder);
            }
            userRepository.save(buyer);
            cartRepository.save(cart);
        }
    }

    @Override
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order!=null && order.getStatus()==OrderStatus.PROCESSING){
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
        }
    }

    @Override
    public Cart getCart(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user!= null){
            return user.getCart();
        }
        return null;
    }

    @Override
    public List<Order> getOrders(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user!= null){
            System.out.println("yser order ::::"+user.getOrders());
            return user.getOrders();
        }
        return List.of();
    }

    @Override
    public void addReview(Long id, Long productId, Review review) {
        User user = userRepository.findById(id).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        if (user != null && product != null) {
            review.setUser(user);
            review.setProduct(product);
            review.setReviewDate(new Date());
            Review savedReview = reviewRepository.save(review);
            product.addReview(savedReview);
            productRepository.save(product);
        }
    }

    @Override
    public void updateReview(Long id, Long reviewId, Review review) {
        if(id == review.getUser().getId()){
            reviewRepository.save(review);
        }
    }

    @Override
    public void deleteReview(Long id, Long reviewId) {
        Review review= reviewRepository.findById( reviewId).orElse(null);
        if(review!= null && id== review.getUser().getId()){
            reviewRepository.deleteById(reviewId);
        }
    }
}
