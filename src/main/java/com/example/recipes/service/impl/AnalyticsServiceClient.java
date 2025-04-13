package com.example.recipes.service.impl;

import com.example.recipes.model.dto.MostCommentedRecipeView;
import com.example.recipes.repository.CommentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceClient {

    private final CommentRepository commentRepository;


    public AnalyticsServiceClient(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<MostCommentedRecipeView> findMostCommentedRecipes() {
        return commentRepository.findTopCommentedRecipes(PageRequest.of(0, 5));
    }
}
