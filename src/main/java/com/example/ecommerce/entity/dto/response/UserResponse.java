package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.user.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
