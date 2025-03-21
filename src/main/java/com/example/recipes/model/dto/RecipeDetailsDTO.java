package com.example.recipes.model.dto;

import java.time.LocalDate;

public class RecipeDetailsDTO {

    private Long id;

    private String description;

    private String title;

    private LocalDate created;

    private String imageUrl;

    private String category;

    private String instructions;

    public RecipeDetailsDTO() {
    }


    public Long getId() {
        return id;
    }

    public RecipeDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RecipeDetailsDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public RecipeDetailsDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeDetailsDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public RecipeDetailsDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public RecipeDetailsDTO setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }
}
