package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.dto.request.OrderStatusRequest;
import com.example.ecommerce.entity.dto.request.UserRequest;
import com.example.ecommerce.entity.dto.response.ProductResponse;
import com.example.ecommerce.entity.dto.response.UserResponse;
import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Item;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.order.OrderStatus;
import com.example.ecommerce.entity.product.Product;
import com.example.ecommerce.entity.product.Review;
import com.example.ecommerce.entity.user.Role;
import com.example.ecommerce.entity.user.User;
import com.example.ecommerce.repository.*;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.generic.GenericServiceImpl;
import com.example.ecommerce.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.ecommerce.entity.order.OrderStatus.*;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserRequest, UserResponse, Long> implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ListMapper listMapper){
        super(userRepository, modelMapper, listMapper);
    }

    public User create(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        if(user.getRoles().getFirst().getRole().equals("BUYER") ){
            user.setEnable(true);
            user.setHasRequestedForApproval(false);
        }
        else{
            user.setEnable(false);
            user.setHasRequestedForApproval(false);
        }
        User savedUser = userRepository.save(user);
        savedUser.getRoles().getFirst().setUser(savedUser);
        roleRepository.save(savedUser.getRoles().getFirst());
        return savedUser;
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return modelMapper.map(userRepository.findByEmail(email),UserResponse.class);
    }

    @Override
    public UserResponse addRoles(Long id, Role role) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            List<Role> roles = user.getRoles();
            if (roles == null) {
                roles = new ArrayList<>();
            }
            roles.add(role);
            user.setRoles(roles);
            return modelMapper.map(userRepository.save(user), UserResponse.class);
        }
        return null;
    }

    @Override
    public Cart addToCart(Long id, List<Item> items) {
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

    @Override
    public Cart getCart(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getCart();
        }
        return null;
    }

    @Override
    public Order createOrder(Long id, List<Item> items) {
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

            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void clearCart(Long userId, List<Long> itemIds) {
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

    @Override
    public List<ProductResponse> addProducts(Long id, List<Product> products) {
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
            return products.stream()
                    .map(product -> modelMapper.map(product, ProductResponse.class))
                    .toList();
        }
        return List.of();
    }

    @Override
    public ProductResponse updateProduct(Long userId, Long productId, Product productDetails) {
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
                        return modelMapper.map(product, ProductResponse.class);
                    }
                }
            }
        }

        return null;
    }

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
    public List<Order> getOrders(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getOrders();
        }
        return List.of();
    }

    @Override
    public List<ProductResponse> getOrderedProducts(Long userId) {
        return orderRepository.findAll()
                .stream()
                .filter(order->order.getStatus().equals(OrderStatus.PROCESSING))
                .map(Order::getOrderItems)
                .flatMap(Collection::stream)
                .map(Item::getProduct)
                .filter(product -> product.getUser().getId().equals(userId))
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .toList();
    }

    @Override
    public List<Order> getOrdersBySeller(Long id) {
        return orderRepository.findAll()
                .stream()
                .filter(order->order.getStatus().equals(OrderStatus.PROCESSING))
                .filter(order -> order.getOrderItems()
                        .stream()
                        .anyMatch(item -> item.getProduct().getUser().getId().equals(id)))
                .toList();
    }

    @Override
    public Order updateOrderStatus(Long id, Long orderId, OrderStatusRequest orderStatus) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
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

           return orderRepository.save(order);

        }
        return null;
    }

    @Override
    public Order cancelOrder(Long id, Long orderId, OrderStatusRequest orderStatus) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            if(order.getStatus()!=null && order.getStatus().equals(OrderStatus.PROCESSING)){
                order.setStatus(OrderStatus.CANCELLED);
            }
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Review addReview(Long id, Long productId, String review) {
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
                        return review1;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public UserResponse approveSeller(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setHasRequestedForApproval(true);
            return modelMapper.map(userRepository.save(user), UserResponse.class);
        }
        return null;
    }

}

