package com.example.ecommerce.controller;

import com.example.ecommerce.entity.dto.request.OrderStatusRequest;
import com.example.ecommerce.entity.dto.response.OrderResponse;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seller")
//@PreAuthorize("hasRole('SELLER')")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/{id}/products")
    public List<ProductResponse> getProducts(@PathVariable Long id){
        return sellerService.getProducts(id);
    }

    @PostMapping(value = "/{id}/add-product")
    public Product addProduct(@PathVariable Long id, @RequestBody Product product){
        return sellerService.addProduct(id, product);
    }

    @DeleteMapping("/{id}/delete-product/{productId}")
    public boolean deleteProduct(@PathVariable Long id, @PathVariable Long productId){
        return sellerService.deleteProduct(id, productId);
    }

    @GetMapping("/{id}/orders")
    public List<OrderResponse> getOrders(@PathVariable Long id){
        return sellerService.getOrders(id);
    }

    @PutMapping("/{id}/orders/{orderId}/cancel")
    public void cancel(@PathVariable Long id, @PathVariable Long orderId){
        sellerService.cancelOrder(id, orderId);
    }

    @PutMapping("/{id}/orders/{orderId}/updateStatus")
    public void updateOrderStatus(@PathVariable Long id, @PathVariable Long orderId, @RequestBody OrderStatusRequest orderStatus){
        sellerService.updateOrderStatus(id, orderId, orderStatus);
    }

    @PutMapping("/{id}/approve-request")
    public UserResponse approveRequest(@PathVariable Long id){
        return sellerService.requestApproval(id);
    }
}

