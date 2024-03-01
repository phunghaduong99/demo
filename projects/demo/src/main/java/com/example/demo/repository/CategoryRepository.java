package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByValue(String value);
}
