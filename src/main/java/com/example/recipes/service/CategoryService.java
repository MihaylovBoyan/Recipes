package com.example.recipes.service;

import com.example.recipes.model.Category;
import com.example.recipes.model.CategoryEnum;

public interface CategoryService {
    Category findByCategoryName(CategoryEnum category);
}
