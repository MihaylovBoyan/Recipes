package com.example.recipes.repository;

import com.example.recipes.model.Category;
import com.example.recipes.model.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Optional<Category> findByName(CategoryEnum name);

}
