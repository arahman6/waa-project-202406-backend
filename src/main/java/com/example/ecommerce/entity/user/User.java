package com.example.ecommerce.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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

    @OneToOne
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}

