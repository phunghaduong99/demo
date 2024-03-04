package com.example.demo.model.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse implements Serializable {
    private UUID id;
    private String username;
    private String name;
    private String role;
    private String jwt;
}
