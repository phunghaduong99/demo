package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.Optional;

public interface CategoryService {

    public Category findByValue(String value);
}
