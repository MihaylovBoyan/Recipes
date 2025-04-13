package com.example.recipes.web;

import com.example.recipes.service.impl.AnalyticsServiceClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


    private final AnalyticsServiceClient analyticsServiceClient;

    public AdminController(AnalyticsServiceClient analyticsServiceClient) {
        this.analyticsServiceClient = analyticsServiceClient;
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model) {

         model.addAttribute("mostCommented", analyticsServiceClient.findMostCommentedRecipes());

        return "admin";
    }


}
