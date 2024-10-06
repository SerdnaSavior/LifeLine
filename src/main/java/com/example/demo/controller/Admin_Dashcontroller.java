package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/admin_dash")
public class Admin_Dashcontroller{
    @GetMapping()
    public String admin_dash () {
    return "admin_dash";
}
}

