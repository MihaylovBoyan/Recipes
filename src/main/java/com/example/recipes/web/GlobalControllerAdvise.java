package com.example.recipes.web;

import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvise {

    private final UserService userService;

    public GlobalControllerAdvise(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addUserDetailsToModel(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            UserDetailsDTO userDetailsDTO = userService.showUserDetailsByUsername(userDetails.getUsername());
            model.addAttribute("userDetailsDTO", userDetailsDTO);
        }
    }

}
