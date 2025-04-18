package com.example.recipes.repository;

import com.example.recipes.model.CategoryEnum;
import com.example.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

  List<Recipe> findByCategoryName(CategoryEnum category);


}
