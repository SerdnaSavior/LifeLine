package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Logoutcontroller {
    @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate();  // Invalidate session

            
            return "redirect:/login";  // Redirect to login page after logout
}
}