package com.example.recipes.service.impl;

import com.example.recipes.model.CategoryEnum;
import com.example.recipes.model.Recipe;
import com.example.recipes.model.dto.RecipeDTO;
import com.example.recipes.model.dto.RecipeDetailsDTO;
import com.example.recipes.repository.RecipeRepository;
import com.example.recipes.service.CategoryService;
import com.example.recipes.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;
    private final CategoryService categoryService;

    public RecipeServiceImpl(ModelMapper modelMapper, RecipeRepository recipeRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<RecipeDTO> findAllRecipes() {
        return recipeRepository.findAll().stream().map(r -> modelMapper.map(r, RecipeDTO.class)).collect(Collectors.toList());
    }


    @Override
    public void save(RecipeDTO recipeDTO) {
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        recipe.setCategory(categoryService.findByCategoryName(recipeDTO.getCategory()));
        recipeRepository.save(recipe);
    }

    @Override
    public RecipeDetailsDTO findById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        return modelMapper.map(recipe, RecipeDetailsDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow();
        //todo

        recipeRepository.save(recipe);

    }

    @Override
    public List<RecipeDTO> findAllBreakfasts(CategoryEnum breakfast) {
        return getRecipeDTOS(breakfast);
    }

    @Override
    public List<RecipeDTO> findAllLunches(CategoryEnum lunch) {
        return getRecipeDTOS(lunch);
    }

    private List<RecipeDTO> getRecipeDTOS(CategoryEnum lunch) {
        List<Recipe> byCategoryName = recipeRepository.findByCategoryName(lunch);
        ArrayList<RecipeDTO> recipeDTOS = new ArrayList<>();

        for (Recipe recipe : byCategoryName) {
            RecipeDTO map = modelMapper.map(recipe, RecipeDTO.class);
            map.setCategory(recipe.getCategory().getName());
            recipeDTOS.add(map);
        }

        return recipeDTOS;
    }

}
