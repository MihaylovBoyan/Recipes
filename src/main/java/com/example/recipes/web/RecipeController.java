package com.example.recipes.web;

import com.example.recipes.model.CategoryEnum;
import com.example.recipes.model.Recipe;
import com.example.recipes.model.RecipeUserDetails;
import com.example.recipes.model.dto.RecipeDTO;
import com.example.recipes.model.dto.RecipeDetailsDTO;
import com.example.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes/add")
    public String addRecipe(Model model) {
        model.addAttribute("categories", CategoryEnum.values());
        return "add-recipe";
    }

    @ModelAttribute(name = "recipe")
    public RecipeDTO recipeDTO() {
        return new RecipeDTO();
    }

    @PostMapping("/recipes/add")
    public String doAddRecipe(@Valid RecipeDTO recipeDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              @AuthenticationPrincipal RecipeUserDetails currentUser) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("recipe", recipeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recipe", bindingResult);
            return "redirect:/recipes/add";
        }
        recipeDTO.setCreatedBy(currentUser.getUsername());
        recipeService.save(recipeDTO);

        return "redirect:/";
    }

    @GetMapping("/recipe/details/{id}")
    private String recipeDetails(@PathVariable("id") Long id, Model model) {
        RecipeDetailsDTO byId = recipeService.findById(id);
        System.out.println(byId.getId());
        model.addAttribute("recipe", recipeService.findById(id));

        return "details";
    }

    @GetMapping("/recipe/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        RecipeDetailsDTO byId = recipeService.findById(id);

        model.addAttribute("recipe", recipeService.findById(id));
        model.addAttribute("categories", CategoryEnum.values());

        return "update";
    }

    @PatchMapping("/recipe/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("recipe") RecipeDTO recipeDTO) {

        recipeService.updateById(id, recipeDTO);

        return "redirect:/";
    }


    @DeleteMapping("/recipe/details/{id}")
    public String delete(@PathVariable Long id) {
        recipeService.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/recipe/{category}")
    public String showRecipesByCategory(@PathVariable String category, Model model) {
        return CategoryEnum.from(category)
                .map(c -> {
                    List<RecipeDTO> recipes = recipeService.findAllByCategory(c);
                    model.addAttribute("recipes", recipes);
                    model.addAttribute("currentCategory", c.name());
                    return "index";
                })
                .orElse("error/404");

    }
}
