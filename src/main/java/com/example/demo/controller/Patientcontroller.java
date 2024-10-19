package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String viewPatients(HttpSession session, Model model,@RequestParam(name = "searchTerm", required = false) String searchTerm,RedirectAttributes redirectAttributes) {
        Users currentUser = (Users) session.getAttribute("currentUser");               
            
        List<Patients> patients;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            patients = patientServiceImpl.searchPatientsByNameOrId(searchTerm);         
            if(patients.isEmpty()){ patients = null;}

        } else {
            patients = patientServiceImpl.getAllPatients();
        }
       


            model.addAttribute("patients", patients);
            model.addAttribute("searchTerm", searchTerm);
            model.addAttribute("user", currentUser);       

        return "viewPatients";
    } 
    @GetMapping("/patientProfile")
        public String viewPatientProfile(@RequestParam Integer id, Model model,HttpSession session) {
            Patients patient = patientServiceImpl.getByIdPatients(id);
            Users currentUser = (Users) session.getAttribute("currentUser");

            session.setAttribute("currentPatient", patient);
            model.addAttribute("patient", patient);
            model.addAttribute("user", currentUser);
            return "patientProfile"; // This will load the Thymeleaf template
        }
        @GetMapping("/updatePatient")
        public String editPatientProfile( Model model,HttpSession session) {
            Patients currentPatient = (Patients) session.getAttribute("currentPatient");
            Users currentUser = (Users) session.getAttribute("currentUser");

            model.addAttribute("currentPatient", currentPatient);
            model.addAttribute("user", currentUser);
            return "updatePatient"; // This will load the Thymeleaf template
        }


    @PostMapping("/savePatient")
    public String registerPatient(HttpSession session,@ModelAttribute("patient") Patients patient,RedirectAttributes redirectAttributes,Model model) {
           
            

            patientServiceImpl.save(patient);
            redirectAttributes.addFlashAttribute("message", "Patient added Successfully!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            
            return "redirect:/registerPatient";
        
    } 
    @PostMapping("/updatePatient")
    public String updatePatient(HttpSession session,@ModelAttribute("patient") Patients patient,RedirectAttributes redirectAttributes,Model model) {
        Patients currentPatient = (Patients) session.getAttribute("currentPatient");
        

         // Update all attributes
            currentPatient.setFirst_name(patient.getFirst_name());
            currentPatient.setLast_name(patient.getLast_name());
            if (patient.getDob() != null) {
                // Update the date of birth only if provided
            currentPatient.setDob(patient.getDob());
            }            
            currentPatient.setGender(patient.getGender());
            currentPatient.setBlood_type(patient.getBlood_type());
            currentPatient.setMarital_status(patient.getMarital_status());
            
            // Contact Information
            currentPatient.setAddress(patient.getAddress());
            currentPatient.setCity(patient.getCity());
            currentPatient.setState(patient.getState());
            currentPatient.setPostal_code(patient.getPostal_code());
            currentPatient.setPhone_number(patient.getPhone_number());
            currentPatient.setEmail(patient.getEmail());

            // Emergency Contact Information
            currentPatient.setEmergency_contact_name(patient.getEmergency_contact_name());
            currentPatient.setEmergency_contact_phone(patient.getEmergency_contact_phone());

            // Medical Information
            currentPatient.setAllergies(patient.getAllergies());
            currentPatient.setHeight(patient.getHeight());
            currentPatient.setWeight(patient.getWeight());
            currentPatient.setBlood_pressure(patient.getBlood_pressure());
            currentPatient.setMedical_history(patient.getMedical_history());

            // Insurance Information
            currentPatient.setInsurance_provider(patient.getInsurance_provider());
            currentPatient.setInsurance_policy_number(patient.getInsurance_policy_number());
            currentPatient.setInsurance_expiration_date(patient.getInsurance_expiration_date());
            currentPatient.setInsurance_type(patient.getInsurance_type());
                    

            patientServiceImpl.save(currentPatient);
            redirectAttributes.addFlashAttribute("message", "Patient Updated Successfully!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            session.removeAttribute("currentPatient");
            
            return "redirect:/patientProfile?id=" + currentPatient.getId();
        
    }
   
}
