package com.example.demo.repository.user;

import com.example.demo.entity.user.Customer;
import com.example.demo.entity.user.UserBaseEntity;
import com.example.demo.model.user.request.RegisterCustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
