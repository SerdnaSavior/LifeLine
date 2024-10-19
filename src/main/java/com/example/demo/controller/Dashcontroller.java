package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Users;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@Controller
@RequestMapping("/dash")
public class Dashcontroller{
    @GetMapping()
        public String admin_dash (HttpSession session, Model model,RedirectAttributes redirectAttributes,@RequestHeader(value = "Referer", required = false) String referer) {
            Users currentUser = (Users) session.getAttribute("currentUser");

            // If user is not logged in, redirect to the login page
            if (currentUser == null) {
                return "redirect:/login";
            }
            // if (!"ADMIN".equals(currentUser.getRole())) {
            //     redirectAttributes.addFlashAttribute("message", "You do not have permission to access this page");
            //     redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            //     return "redirect:" + (referer != null ? referer : "/access-denied");
            // }

            // Add user info to the model to display on the dashboard
            model.addAttribute("user", currentUser);
             return "dash";
}
}

