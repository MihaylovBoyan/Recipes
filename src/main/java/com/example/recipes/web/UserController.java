package com.example.recipes.web;

import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.model.dto.UserLoginDTO;
import com.example.recipes.model.dto.UserRegisterDTO;
import com.example.recipes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegisterUser(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "redirect:register";
        }

        userService.registerUser(userRegisterDTO);

        return "redirect:/login";
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }


    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginDTO")) {
            model.addAttribute("userLoginDTO", new UserLoginDTO());
        }
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {

        model.addAttribute("loginError", true);
        model.addAttribute("userLoginDTO", new UserLoginDTO());
        return "login";
    }


    @GetMapping("/profile/{id}")
    public String details(@PathVariable Long id, Model model) {

        model.addAttribute("userDetailsDTO", userService.showUserDetailsById(id));

        return "profile";
    }

    @PostMapping("/profile-picture")
    public String uploadProfilePicture(@RequestParam("image") MultipartFile image,
                                       @AuthenticationPrincipal UserDetails userDetails) throws IOException {
        userService.saveProfilePicture(userDetails.getUsername(), image);
        Long id = userService.findIdByUsername(userDetails.getUsername());
        return "redirect:/users/profile/" + id;
    }


}
