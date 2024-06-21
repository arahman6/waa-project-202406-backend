package com.example.ecommerce.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {
    private Long id;
    private Integer quantity;
    private Double price;
    private ProductResponse product;
}
