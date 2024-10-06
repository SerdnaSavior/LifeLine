package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Users;
import com.example.demo.service.UserServiceImpl;




@Controller
@RequestMapping("/login")
public class Logincontroller {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping()
    public String login(Model model) {
        model.addAttribute("alluserlist", userServiceImpl.getAllUsers());
        return "login";
    } 

    @PostMapping()
    public String postMethodName(@ModelAttribute("user") Users user , RedirectAttributes redirectAttributes) {

        
        // redirectAttributes.addFlashAttribute("message", "Username already taken.");
        // redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        //     return "redirect:/login"; // Redirect back to the signup page
        
        
        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/admin_dash";
    }
}



