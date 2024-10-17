package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Users;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/aboutus")
public class aboutuscontroller {
@GetMapping()
    public String aboutus(HttpSession session, Model model) {
        Users currentUser = (Users) session.getAttribute("currentUser");

            // If user is not logged in, redirect to the login page
            if (currentUser != null) {
                 // Add user info to the model to display on the dashboard
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("user", currentUser);
            }

        return "aboutus";
    } 
}
