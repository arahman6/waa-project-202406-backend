package com.example.ecommerce.entity.category;

import com.example.ecommerce.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import lombok.Data;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Data
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JsonBackReference(value = "category-subCategory")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "product-subCategory")
    @ToString.Exclude
    private List<Product> products;

}

