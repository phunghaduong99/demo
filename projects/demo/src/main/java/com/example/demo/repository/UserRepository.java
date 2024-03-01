package com.example.demo.repository;

import com.example.demo.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Seller, UUID> {
}
