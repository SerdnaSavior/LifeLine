package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

@Controller

public class Logincontroller {
    
    @GetMapping("/login")
    public String signup() {
        return "login";
    } 
}


