package com.example.ecommerce.entity.user;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "admin_users")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    @OneToOne
    private Address address;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
