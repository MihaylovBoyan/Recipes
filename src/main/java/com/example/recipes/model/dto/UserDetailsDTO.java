package com.example.recipes.model.dto;

import com.example.recipes.model.Recipe;

import java.util.List;

public class UserDetailsDTO {

    private Long id;

    private String fullName;

    private String username;

    private Integer age;

    private String level;

    private List<Recipe> recipes;

    public UserDetailsDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserDetailsDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDetailsDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserDetailsDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public UserDetailsDTO setLevel(String level) {
        this.level = level;
        return this;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public UserDetailsDTO setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }
}
