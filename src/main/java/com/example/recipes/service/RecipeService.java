package com.example.recipes.service;

import com.example.recipes.model.dto.RecipeDTO;
import com.example.recipes.model.dto.RecipeDetailsDTO;

import java.util.List;

public interface RecipeService {
    List<RecipeDTO> findAllRecipes();

    void save(RecipeDTO recipeDTO);

    RecipeDetailsDTO findById(Long id);

    void deleteById(Long id);

    void updateById(Long id, RecipeDTO recipeDTO);
}
