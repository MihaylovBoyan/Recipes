package com.example.recipes.web;

import com.example.recipes.model.Recipe;
import com.example.recipes.model.dto.RecipeDTO;
import com.example.recipes.model.dto.RecipeDetailsDTO;
import com.example.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("recipes", recipeService.findAllRecipes());


        return "index";
    }


    @GetMapping("/recipes/add")
    public String addRecipe(){

    return "add-recipe";
    }

    @ModelAttribute(name = "recipe")
    public RecipeDTO recipeDTO(){
        return new RecipeDTO();
    }

    @PostMapping("/recipes/add")
    public String doAddRecipe(@Valid RecipeDTO recipeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("recipe", recipeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recipe", bindingResult);
            return "redirect:/recipes/add";
        }

        recipeService.save(recipeDTO);

        return "redirect:/";
    }

    @GetMapping("/recipe/{id}")
    private String recipeDetails(@PathVariable("id") Long id, Model model){
        RecipeDetailsDTO byId = recipeService.findById(id);
        System.out.println(byId.getId());
        model.addAttribute("recipe", recipeService.findById(id));

        return "details";
    }

    @DeleteMapping("/recipe/{id}")
    public String delete(@PathVariable Long id){
        recipeService.deleteById(id);
        return "redirect:/";
    }

}
