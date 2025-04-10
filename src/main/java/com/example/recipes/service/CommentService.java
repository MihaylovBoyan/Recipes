package com.example.recipes.service;

import com.example.recipes.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByRecipeId(Long recipeId);

    Comment addComment(Long recipeId, Comment comment);

    Comment updateComment(Long commentId, Comment comment);

    void deleteComment(Long commentId);
}
