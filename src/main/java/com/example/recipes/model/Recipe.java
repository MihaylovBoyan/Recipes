package com.example.recipes.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(columnDefinition = "LONGTEXT")
    private String imageUrl;

    @Column(columnDefinition = "LONGTEXT")
    private String instructions;

    @ManyToOne
    private Category category;

    private LocalDate created;

    @ManyToOne
    private User createdBy;

    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public Recipe setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Recipe setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Recipe setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Recipe setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Recipe setCategory(Category category) {
        this.category = category;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Recipe setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getInstructions() {
        return instructions;
    }

    public Recipe setInstructions(String instructions) {
        this.instructions = instructions;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Recipe setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
