package com.example.ecommerce.entity.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequest {
    @NotNull(message = "Status must not be null")
    private String status;
}
