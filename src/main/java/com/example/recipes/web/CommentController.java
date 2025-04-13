package com.example.recipes.web;

import com.example.recipes.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/recipes/{id}/comments")
    public String addComment(@PathVariable Long id, @RequestParam String text, @AuthenticationPrincipal UserDetails userDetails){


        commentService.addComment(id, text, userDetails);
        return "redirect:/recipe/details/" + id;
    }

    @PostMapping("/comments/{id}/approve")
    public String approve(@PathVariable Long id) {
        commentService.approve(id);
        return "redirect:/admin/comments";
    }

    @DeleteMapping("/comments/{id}")
    public String delete(@PathVariable Long id) {
        commentService.delete(id);
        return "redirect:/admin/comments";
    }


}
