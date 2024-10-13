package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/admin_dash")
public class Admin_Dashcontroller{
    @GetMapping()
        public String admin_dash (HttpSession session, Model model) {
            String currentUser = (String) session.getAttribute("currentUser");

            // If user is not logged in, redirect to the login page
            if (currentUser == null) {
                return "redirect:/login";
            }

            // Add user info to the model to display on the dashboard
            model.addAttribute("username", currentUser);
             return "admin_dash";
}
}

