package com.example.demo.repository.user;

import com.example.demo.entity.user.UserBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserBaseEntity, UUID> {
    Optional<UserBaseEntity> findByUsername(String username);
}
