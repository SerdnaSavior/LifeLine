package com.example.demo.controller;

import com.example.demo.model.Appointments;
import com.example.demo.model.Users;
import com.example.demo.service.AppointmentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Appointmentscontroller {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/schedule_appointment")
    public String showAppointmentForm(Model model,HttpSession session) {
         Users currentUser = (Users) session.getAttribute("currentUser");


        model.addAttribute("appointment", new Appointments());
        model.addAttribute("user", currentUser);
        return "schedule_appointment";  // Refers to the Thymeleaf template for scheduling appointments
    }

    @PostMapping("/schedule_appointment")
    public String scheduleAppointment(@ModelAttribute("appointment") Appointments appointment, Model model) {
        appointmentService.saveAppointment(appointment);


        model.addAttribute("message", "Appointment successfully booked!");
        return "redirect:/appointments"; // Redirect to a page showing appointments
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model,HttpSession session) {
        Users currentUser = (Users) session.getAttribute("currentUser");


        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("user", currentUser);   
        return "appointments";  // A view showing a list of all appointments
    }
}