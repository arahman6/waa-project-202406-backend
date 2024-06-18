package com.example.ecommerce.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User user;

    // Getters and Setters
}

