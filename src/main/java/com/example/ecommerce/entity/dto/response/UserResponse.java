package com.example.ecommerce.entity.dto.response;

import com.example.ecommerce.entity.user.Address;
import com.example.ecommerce.entity.user.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private List<Role> roles;
}
