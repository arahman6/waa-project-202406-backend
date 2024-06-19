package com.example.ecommerce.entity.user;

import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private boolean enable;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
    @JsonManagedReference
    private List<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order> orders;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Cart cart;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Product> products;
}

