package com.example.recipes.web;

import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("fileError", "File is too large! Max 5MB allowed.");
        return "redirect:/users/profile"; // or wherever the upload form is
    }


}
