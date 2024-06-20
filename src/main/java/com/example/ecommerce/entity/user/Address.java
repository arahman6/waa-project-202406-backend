package com.example.ecommerce.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

    @OneToOne
    @JsonBackReference(value = "user-address")
    @ToString.Exclude
    private User user;

}

