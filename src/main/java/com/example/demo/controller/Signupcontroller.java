package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class Signupcontroller {
    
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    } 
}