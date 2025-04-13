package com.example.recipes.service.impl;

import com.example.recipes.model.Comment;
import com.example.recipes.model.Recipe;
import com.example.recipes.repository.CommentRepository;
import com.example.recipes.repository.RecipeRepository;
import com.example.recipes.service.CommentService;
import com.example.recipes.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RecipeRepository recipeRepository;
    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository, RecipeRepository recipeRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.recipeRepository = recipeRepository;
        this.userService = userService;
    }

    public List<Comment> getCommentsByRecipeId(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }

    @Override
    public void addComment(Long id, String text, UserDetails userDetails) {

        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now())
                .setTextContent(text)
                .setRecipe(recipeRepository.findById(id).orElseThrow())
                .setAuthor(userService.findByUsername(userDetails.getUsername()))
                .setApproved(false);

        commentRepository.save(comment);
    }

    @Override
    public void approve(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.setApproved(true);
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

}
