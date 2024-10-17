package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestHeader;


import com.example.demo.model.Users;
import com.example.demo.repo.UserRepository;



@Controller
@RequestMapping("/pat_dash")
public class pat_dashcontroller{    

    @GetMapping()
        public String pat_dash (HttpSession session, Model model,RedirectAttributes redirectAttributes,@RequestHeader(value = "Referer", required = false) String referer) {
           
            Users currentUser = (Users) session.getAttribute("currentUser");
            
            // If user is not logged in, redirect to the login page
            if (currentUser == null) {
                return "redirect:/login";
            }
            if (!"patient".equals(currentUser.getRole())) {
                redirectAttributes.addFlashAttribute("message", "You do not have permission to access this page");
                redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
                return "redirect:" + (referer != null ? referer : "/access-denied");
            }
            
            // Add user info to the model to display on the dashboard
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("user", currentUser);
             return "pat_dash";
}
}