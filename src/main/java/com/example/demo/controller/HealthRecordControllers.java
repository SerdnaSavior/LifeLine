package com.example.demo.controller;

import com.example.demo.model.HealthRecords;
import com.example.demo.model.Users;
import com.example.demo.service.HealthRecordService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HealthRecordControllers {

    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping("/health_records")
    public String listHealthRecords(Model model,HttpSession session) {
        Users currentUser = (Users) session.getAttribute("currentUser");


        model.addAttribute("user", currentUser);
        model.addAttribute("healthRecords", healthRecordService.getAllHealthRecords());
        return "health_records"; // View listing all health records
    }

    @GetMapping("/add_health_record")
    public String showAddHealthRecordForm(Model model,HttpSession session) {
        Users currentUser = (Users) session.getAttribute("currentUser");


        model.addAttribute("user", currentUser);
        model.addAttribute("healthRecord", new HealthRecords());
        return "add_health_record"; // View for adding a health record
    }

    @PostMapping("/add_health_record")
    public String addHealthRecord(@ModelAttribute("healthRecord") HealthRecords healthRecord) {        
        healthRecordService.saveHealthRecord(healthRecord);
        return "redirect:/health_records"; // Redirect to list of health records
    }

    @GetMapping("/view_health_record")
    public String viewHealthRecord(@RequestParam Long id, Model model,HttpSession session) {
        Users currentUser = (Users) session.getAttribute("currentUser");
        HealthRecords healthRecord = healthRecordService.getHealthRecordById(id);
        
        model.addAttribute("user", currentUser);
        model.addAttribute("healthRecord", healthRecord);
        return "view_health_record"; // View a specific health record
    }
}