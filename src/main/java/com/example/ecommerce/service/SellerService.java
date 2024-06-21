package com.example.ecommerce.service;

import com.example.ecommerce.entity.dto.request.OrderStatusRequest;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SellerService {
    List<ProductResponse> getProducts(Long id);
    Product addProduct(Long id, Product product);
    boolean deleteProduct(Long sellerId, Long productId);
    List<OrderResponse> getOrders(Long sellerId);
    void cancelOrder(Long sellerId, Long orderId);
    void updateOrderStatus(Long sellerId, Long orderId, OrderStatusRequest orderStatusRequest);
    UserResponse requestApproval(Long id);


}
