package com.example.recipes.service.impl;

import com.example.recipes.model.Recipe;
import com.example.recipes.model.dto.RecipeDTO;
import com.example.recipes.model.dto.RecipeDetailsDTO;
import com.example.recipes.repository.RecipeRepository;
import com.example.recipes.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final ModelMapper modelMapper;
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(ModelMapper modelMapper, RecipeRepository recipeRepository) {
        this.modelMapper = modelMapper;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<RecipeDTO> findAllRecipes() {

        return recipeRepository.findAll().stream().map(r -> modelMapper.map(r, RecipeDTO.class)).collect(Collectors.toList());

    }

    @Override
    public void save(RecipeDTO recipeDTO) {
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
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
}
