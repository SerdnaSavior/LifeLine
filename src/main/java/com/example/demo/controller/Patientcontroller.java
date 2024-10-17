package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;

import com.example.demo.model.Patients;
import com.example.demo.model.Users;
import com.example.demo.service.PatientServiceImpl;




@Controller
public class Patientcontroller {
@Autowired
    private PatientServiceImpl patientServiceImpl ;

    
@GetMapping("/registerPatient")
    public String registerPatient(HttpSession session, Model model) {
        Users currentUser = (Users) session.getAttribute("currentUser");
        Patients patient = new Patients();
            model.addAttribute("patient", patient);      
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("user", currentUser);
        return "registerPatient";
    } 

    @GetMapping("/viewPatients")
    public String viewPatients(HttpSession session, Model model,@RequestParam(name = "searchTerm", required = false) String searchTerm) {
        Users currentUser = (Users) session.getAttribute("currentUser");               
            
        List<Patients> patients;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            patients = patientServiceImpl.searchPatientsByNameOrId(searchTerm);
        } else {
            patients = patientServiceImpl.getAllPatients();
        }
       


            model.addAttribute("patients", patients);
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("user", currentUser);       

        return "viewPatients";
    } 


@PostMapping("/savePatient")
    public String registerPatient(HttpSession session,@ModelAttribute("patient") Patients patient,RedirectAttributes redirectAttributes,Model model) {
        Users currentUser = (Users) session.getAttribute("currentUser");    
            

            patientServiceImpl.save(patient);
            redirectAttributes.addFlashAttribute("message", "Changes to User Profile were Successful!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            
            return "redirect:/registerPatient";
        
    }
}
