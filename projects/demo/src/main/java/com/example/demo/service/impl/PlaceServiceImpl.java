package com.example.demo.service.impl;

import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.PlaceService;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

}
