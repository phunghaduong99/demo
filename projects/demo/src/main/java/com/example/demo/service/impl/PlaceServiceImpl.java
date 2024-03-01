package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.Place;
import com.example.demo.handle.NotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PlaceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    @Override
    public Place findByValue(String value) {
        Optional<Place> result = this.placeRepository.findByValue(value);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NotFoundException("Place with this name not found");
        }
    }
}
