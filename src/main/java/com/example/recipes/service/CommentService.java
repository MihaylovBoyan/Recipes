package com.example.recipes.service;

import com.example.recipes.model.Comment;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByRecipeId(Long recipeId);

    void addComment(Long id, String text, UserDetails userDetails);

    void approve(Long id);

    void delete(Long id);
}
