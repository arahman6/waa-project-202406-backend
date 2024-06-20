package com.example.ecommerce.entity.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class OrderStatusRequest {
    @NotNull(message = "Status must not be null")
    private String status;
}
