package com.example.demo.entity;

import com.example.demo.entity.enumration.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User extends BaseEntity{
    private String username;
    private String email;
    private String password;
    private Role role;
}
