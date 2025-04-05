package com.example.recipes.service.impl;

import com.example.recipes.model.Category;
import com.example.recipes.model.CategoryEnum;
import com.example.recipes.repository.CategoryRepository;
import com.example.recipes.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByCategoryName(CategoryEnum category) {
        return categoryRepository.findByName(category).orElseThrow();
    }
}
