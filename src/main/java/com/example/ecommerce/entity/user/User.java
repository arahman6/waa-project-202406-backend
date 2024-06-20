package com.example.ecommerce.entity.user;

import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
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

    @Column(nullable = true, columnDefinition = "boolean default false")
    private Boolean enable;

    @Column(nullable = true, columnDefinition = "boolean default false")
    private Boolean hasRequestedForApproval;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-address")
    @ToString.Exclude
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
    @JsonManagedReference(value = "user-roles")
    @ToString.Exclude
    private List<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-orders")
    @ToString.Exclude
    private List<Order> orders;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-cart")
    @ToString.Exclude
    private Cart cart;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-products")
    @ToString.Exclude
    private List<Product> products;
}

