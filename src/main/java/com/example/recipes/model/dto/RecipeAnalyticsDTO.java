package com.example.recipes.model.dto;

public class RecipeAnalyticsDTO {

    private Long recipeId;
    private String title;
    private String category;
    private int views;
    private Integer comments;

    public Long getRecipeId() {
        return recipeId;
    }

    public RecipeAnalyticsDTO setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RecipeAnalyticsDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public RecipeAnalyticsDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getViews() {
        return views;
    }

    public RecipeAnalyticsDTO setViews(int views) {
        this.views = views;
        return this;
    }

    public Integer getComments() {
        return comments;
    }

    public RecipeAnalyticsDTO setComments(Integer comments) {
        this.comments = comments;
        return this;
    }
}
