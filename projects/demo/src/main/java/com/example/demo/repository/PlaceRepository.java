package com.example.demo.repository;

import com.example.demo.entity.Image;
import com.example.demo.entity.Place;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, String> {

    Optional<Place> findByValue(String value);
}
