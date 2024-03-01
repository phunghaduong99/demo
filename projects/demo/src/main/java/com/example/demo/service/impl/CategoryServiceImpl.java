package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.handle.NotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByValue(String value) {
        Optional<Category> result = this.categoryRepository.findByValue(value);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NotFoundException("Category with this name not found");
        }
    }
}
