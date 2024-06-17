package com.example.ecommerce.entity.category;

import com.example.ecommerce.entity.product.Product;
import jakarta.persistence.Entity;
import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Product> products;

}

