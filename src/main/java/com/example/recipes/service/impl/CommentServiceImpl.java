package com.example.recipes.service.impl;

import com.example.recipes.model.Comment;
import com.example.recipes.model.Recipe;
import com.example.recipes.repository.CommentRepository;
import com.example.recipes.repository.RecipeRepository;
import com.example.recipes.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RecipeRepository recipeRepository;

    public CommentServiceImpl(CommentRepository commentRepository, RecipeRepository recipeRepository) {
        this.commentRepository = commentRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Comment> getCommentsByRecipeId(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }

    public Comment addComment(Long recipeId, Comment comment) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));
        comment.setRecipe(recipe);
        comment.setCreated(Instant.now());
        comment.setApproved(false); // Default to not approved
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        existingComment.setTextContent(updatedComment.getTextContent());
        return commentRepository.save(existingComment);
    }

    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new IllegalArgumentException("Comment not found");
        }
        commentRepository.deleteById(commentId);
    }

}
