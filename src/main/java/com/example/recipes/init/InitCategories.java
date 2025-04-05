package com.example.recipes.init;

import com.example.recipes.model.Category;
import com.example.recipes.model.CategoryEnum;
import com.example.recipes.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitCategories implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public InitCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0) {

            CategoryEnum[] values = CategoryEnum.values();

            for (CategoryEnum value : values) {
                Category category = new Category().setName(value);
                categoryRepository.save(category);
            }
        }

    }
}
