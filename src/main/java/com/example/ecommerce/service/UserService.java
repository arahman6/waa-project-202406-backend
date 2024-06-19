package com.example.ecommerce.service;

import com.example.ecommerce.controller.ProductController;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.Role;
import com.example.ecommerce.entity.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        Role role = new Role();
        role.setUser(user);
        role.setRole("USER");
        List<Role> roles = user.getRoles();
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(role);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        userRepository.deleteById(id);
        return userRepository.save(userDetails);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    public User addRoles(Integer id, Role role) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            List<Role> roles = user.getRoles();
            if (roles == null) {
                roles = new ArrayList<>();
            }
            roles.add(role);
            user.setRoles(roles);
            return userRepository.save(user);
        }
        return null;
    }


    public Cart addToCart(Integer id, List<Item> items) {
        Optional<User> userOptional = userRepository.findById(id);
           if (userOptional.isPresent()) {
                User user = userOptional.get();
                Cart cart = user.getCart();
                if (cart == null) {
                     cart = new Cart();
                     cart.setUser(user);
                }

                List<Item> cartItems = cart.getCartItems();

                if (cartItems == null) {
                    cartItems = new ArrayList<>();
                }

                cartItems.addAll(items);
                cart.setCartItems(cartItems);
                user.setCart(cart);
                userRepository.save(user);
                return cart;

            }
           return null;
    }

    public Cart getCart(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getCart();
        }
        return null;
    }

    public Order createOrder(Integer id, List<Item> items) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Order> orders = user.getOrders();
            if (orders == null) {
                orders = new ArrayList<>();
            }
            Order order = new Order();
            order.setUser(user);
            order.setOrderItems(items);
            orders.add(order);
            user.setOrders(orders);
            userRepository.save(user);
            return order;
        }
        return null;
    }

    public void clearCart(Integer userId, List<Long> itemIds) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Cart cart = user.getCart();
            List<Item> cartItems = cart.getCartItems();
            cartItems.removeIf(item -> itemIds.contains(item.getId()));
            cart.setCartItems(cartItems);
            user.setCart(cart);
            userRepository.save(user);
        }
    }

    public void addProducts(Integer id, List<Product> products) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Product> userProducts = user.getProducts();
            if (userProducts == null) {
                userProducts = new ArrayList<>();
            }
            userProducts.addAll(products);
            user.setProducts(userProducts);

            userRepository.save(user);
        }
    }

    public Product updateProduct(Integer userId,Long productId, Product productDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Product> userProducts = user.getProducts();
            if (userProducts != null) {
                for (Product product : userProducts) {
                    if (product.getId().equals(productId)) {
                        Product.builder()
                                .name(productDetails.getName())
                                .description(productDetails.getDescription())
                                .price(productDetails.getPrice())
                                .imageUrl(productDetails.getImageUrl())
                                .stockQuantity(productDetails.getStockQuantity())
                                .subCategory(productDetails.getSubCategory())
                                .review(productDetails.getReview())
                                .user(user)
                                .build();
                        productRepository.save(product);
                        return product;
                    }
                }
            }
        }

        return null;
    }

    public List<Product> getProducts(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getProducts();
        }
        return List.of();
    }

    public List<Order> getOrders(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getOrders();
        }
        return List.of();
    }

    public List<Product> getOrderedProducts(Integer userId) {
        return orderRepository.findAll()
                .stream()
                .filter(order->order.getStatus().equals(OrderStatus.PROCESSING))
                .map(Order::getOrderItems)
                .flatMap(Collection::stream)
                .map(Item::getProduct)
                .filter(product -> product.getUser().getId().equals(userId))
                .toList();
    }

    public List<Order> getOrdersBySeller(Integer id) {
        return orderRepository.findAll()
                .stream()
                .filter(order->order.getStatus().equals(OrderStatus.PROCESSING))
                .filter(order -> order.getOrderItems()
                        .stream()
                        .anyMatch(item -> item.getProduct().getUser().getId().equals(id)))
                .toList();
    }

    public Order updateOrderStatus(Integer id, Long orderId, OrderStatus orderStatus) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {

            Order order = orderOptional.get();
            order.setStatus(orderStatus);

            if(orderStatus==OrderStatus.SHIPPED){
                List<Item> items=order.getOrderItems()
                        .stream()
                        .map(item-> {
                            Integer updatedQuantity=item.getProduct().getStockQuantity()-item.getQuantity();
                            item.getProduct().setStockQuantity(updatedQuantity);
                            return item;
                        }).toList();
                order.setOrderItems(items);
            }

           return orderRepository.save(order);

        }
        return null;

    }

    public Order cancelOrder(Integer id, Long orderId, OrderStatus orderStatus) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            if(order.getStatus().equals(OrderStatus.PROCESSING)){
                order.setStatus(orderStatus);
            }
            return orderRepository.save(order);
        }
        return null;
    }

    public Product addReview(Integer id, Long productId, String review) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Product> userProducts = user.getProducts();
            if (userProducts != null) {
                for (Product product : userProducts) {
                    if (product.getId().equals(productId)) {
                        List <Review> reviews = product.getReview();
                        Review review1 = new Review();
                        review1.setComment(review);
                        review1.setReviewDate(new Date());
                        review1.setUser(user);
                        review1.setProduct(product);
                        reviews.add(review1);
                        product.setReview(reviews);
                        productRepository.save(product);
                        return product;
                    }
                }
            }
        }
        return null;
    }

    public User approveSeller(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setHasRequestedForApproval(true);
            return userRepository.save(user);
        }
        return null;
    }
}

