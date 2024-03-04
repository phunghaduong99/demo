package com.example.demo.model.user.request;

import com.example.demo.entity.enumration.Gender;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterCustomerRequest extends RegisterUserRequest {
    @NonNull
    private Gender gender;
}
