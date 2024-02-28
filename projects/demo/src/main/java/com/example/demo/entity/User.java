package com.example.demo.entity;

import com.example.demo.entity.enumration.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User extends BaseEntity{

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
