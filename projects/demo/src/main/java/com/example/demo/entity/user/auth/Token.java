package com.example.demo.entity.user.auth;

import com.example.demo.entity.user.UserBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2080)
    private String token;
    private Date expiration;
    @Column(name = "is_valid")
    private boolean isValid ;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = UserBaseEntity.class)
    @JoinColumn(name = "user_id")
    private UserBaseEntity userBaseEntity;
}