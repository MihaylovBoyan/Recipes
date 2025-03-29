package com.example.recipes.web;

import com.example.recipes.model.dto.UserRegisterDTO;
import com.example.recipes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String registerUser(){

        return "register";
    }


    @PostMapping("/register")
    public String doRegisterUser(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "redirect:/register";
        }

        userService.registerUser(userRegisterDTO);

        return "redirect:/";
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
