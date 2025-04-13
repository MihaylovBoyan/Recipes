package com.example.recipes.repository;

import com.example.recipes.model.Comment;
import com.example.recipes.model.dto.MostCommentedRecipeView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByRecipeId(Long recipeId);

    @Query("""
        SELECT r.id AS recipeId, r.title AS title, COUNT(c.id) AS commentCount
        FROM Comment c
        JOIN c.recipe r
        GROUP BY r.id, r.title
        ORDER BY commentCount DESC
    """)
    List<MostCommentedRecipeView> findTopCommentedRecipes(Pageable pageable);
}
