package com.example.recipes.web;

import com.example.recipes.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());
        return "index";
    }

}
