package com.example.demo.repository;

import com.example.demo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID> {
    Optional<Place> findByCode(String code);
}
