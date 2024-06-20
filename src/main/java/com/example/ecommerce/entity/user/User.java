package com.example.ecommerce.entity.user;

import com.example.ecommerce.entity.order.Cart;
import com.example.ecommerce.entity.order.Order;
import com.example.ecommerce.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
//    @Size(min = 8, message = "Password must be at least 8 characters long")
//    private String password;
//    @Pattern(
//        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
//        message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and no whitespace"
//    )
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
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

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void addOrder(Order order){orders.add(order);}
}

