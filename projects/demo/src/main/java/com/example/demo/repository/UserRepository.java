package com.example.demo.repository;

import com.example.demo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Place, String> {
}