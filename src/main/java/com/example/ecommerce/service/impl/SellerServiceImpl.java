package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.dto.request.OrderStatusRequest;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.SellerService;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.ecommerce.entity.order.OrderStatus.*;
import static com.example.ecommerce.entity.order.OrderStatus.SHIPPED;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<ProductResponse> getProducts(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getProducts()
                    .stream()
                    .map(product -> modelMapper.map(product, ProductResponse.class)).toList() ;
        }
        return List.of();
    }

    @Override
    public Product addProduct(Long id, Product product) {
        User seller = userRepository.findById(id).orElse(null);
        if(seller != null){
            product.setUser(seller);
            Product savedProduct = productRepository.save(product);
            seller.addProduct(savedProduct);
            userRepository.save(seller);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(Long sellerId, Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        User seller = userRepository.findById(sellerId).orElse(null);
        if(seller != null && product != null && product.isPurchased()==false) {
            seller.removeProduct(product);
            userRepository.save(seller);
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderResponse> getOrders(Long sellerId) {
        return listMapper.mapList(orderRepository.findAll()
                .stream()
                //.filter(order->order.getStatus().equals(OrderStatus.PROCESSING))
                .filter(order -> order.getSellerId().equals(sellerId))
                .toList(), new OrderResponse());
    }

    @Override
    public void cancelOrder(Long sellerId, Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order!= null && order.getSellerId().equals(sellerId)){
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
            System.out.println("order canceled");
        }
        System.out.println("order error");
    }

    @Override
    public void updateOrderStatus(Long sellerId, Long orderId, OrderStatusRequest orderStatus) {
        if (orderStatus == null || orderStatus.getStatus() == null) {
            throw new IllegalArgumentException("Order status must not be null");
        }
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order!= null && order.getSellerId().equals(sellerId)) {

            switch (orderStatus.getStatus()) {
                case "SHIPPED":
                    order.setStatus(SHIPPED);
                    break;
                case "DELIVERED":
                    order.setStatus(DELIVERED);
                    break;
                case "CANCELLED":
                    order.setStatus(CANCELLED);
                    break;

            }

            if(order.getStatus()== SHIPPED){
                List<Item> items=order.getOrderItems()
                        .stream()
                        .map(item-> {
                            Integer updatedQuantity=item.getProduct().getStockQuantity()-item.getQuantity();
                            item.getProduct().setStockQuantity(updatedQuantity);
                            return item;
                        }).toList();
                order.setOrderItems(items);
            }

            if (order.getStatus()==DELIVERED){
                order.setDeliveryDate(LocalDateTime.now());
            }

            orderRepository.save(order);

        }

    }

    @Override
    public UserResponse requestApproval(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setHasRequestedForApproval(true);
            return modelMapper.map(userRepository.save(user), UserResponse.class);
        }
        return null;
    }
}
