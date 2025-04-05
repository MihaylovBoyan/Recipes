package com.example.recipes.model.dto;


import com.example.recipes.model.CategoryEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class RecipeDTO {

    private Long id;

    @NotBlank(message = "Heyyyy")
    @Size(min = 3, max = 30)
    private String title;


    @NotBlank(message = "Text must be between 10 and 10000 words")
    @Size(min = 10, max = 3000000)
    private String description;

    @NotBlank(message = "Text must be between 10 and 10000 words")
    @Size(min = 10, max = 3000000)
    private String instructions;

    private LocalDate created;

    private String imageUrl;

    private CategoryEnum category;

    public RecipeDTO() {
        this.created = LocalDate.now();
    }




    public String getTitle() {
        return title;
    }

    public RecipeDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public RecipeDTO setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public RecipeDTO setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public RecipeDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RecipeDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
