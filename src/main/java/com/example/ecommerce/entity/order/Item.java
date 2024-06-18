package com.example.ecommerce.entity.order;

import com.example.ecommerce.entity.product.Product;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;
    private Double price;

}

