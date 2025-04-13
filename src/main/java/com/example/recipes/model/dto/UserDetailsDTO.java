package com.example.recipes.model.dto;

import com.example.recipes.model.Recipe;

import java.util.List;

public class UserDetailsDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private Long age;

    private String level;

    private String email;

    private String profilePictureUrl;

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

    public String getFirstName() {
        return firstName;
    }

    public UserDetailsDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetailsDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDetailsDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public UserDetailsDTO setAge(Long age) {
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

    public String getEmail() {
        return email;
    }

    public UserDetailsDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public UserDetailsDTO setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
        return this;
    }
}
