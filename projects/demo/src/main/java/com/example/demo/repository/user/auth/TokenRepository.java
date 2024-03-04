package com.example.demo.repository.user.auth;

import com.example.demo.entity.user.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    Optional<Token> findByToken(String jwt);
}
