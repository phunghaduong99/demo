package com.example.demo.model.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterSellerRequest extends RegisterUserRequest {
    private String phoneNumber;
}
