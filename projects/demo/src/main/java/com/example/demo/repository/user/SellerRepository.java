package com.example.demo.repository.user;

import com.example.demo.entity.user.Customer;
import com.example.demo.entity.user.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
}
