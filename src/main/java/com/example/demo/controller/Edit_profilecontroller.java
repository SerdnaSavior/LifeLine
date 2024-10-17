package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Users;
import com.example.demo.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;



@Controller
public class Edit_profilecontroller {

     @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/view_profile")
    public String viewUser (HttpSession session, Model model,RedirectAttributes redirectAttributes) {
             Users currentUser = (Users) session.getAttribute("currentUser");
 
            
             model.addAttribute("user", currentUser);
         return "view_profile";
    } 

    @GetMapping("/edit_profile")
    public String editProfile(HttpSession session, Model model) {
        Users currentUser = (Users) session.getAttribute("currentUser");

        model.addAttribute("user", currentUser);
        return "edit_profile";
    }
    


     @PostMapping("/edit_profile")
    public String editUser(HttpSession session,@ModelAttribute("user") Users user,RedirectAttributes redirectAttributes,Model model) {
        Users currentUser = (Users) session.getAttribute("currentUser");


        
            // Update the existing user's fields with the form data
            currentUser.setFirst_name(user.getFirst_name());
            currentUser.setLast_name(user.getLast_name());
            if (user.getDob() != null) {
                // Update the date of birth only if provided
                currentUser.setDob(user.getDob());
            }
            currentUser.setEmail(user.getEmail());
            if (!user.getPassword().isEmpty()) {
                // Update password only if provided and apply hashing if necessary
                // if (!user.getPassword().equals(confirmpassword)) {
                //     redirectAttributes.addFlashAttribute("message", "Passwords do not match!");
                //     redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
                //     return "redirect:/edit_profile"; // Redirect back to the signup page
                    
                // }
                currentUser.setPassword(user.getPassword()); // remember to hash the password
            }    



            userServiceImpl.save(currentUser);
            redirectAttributes.addFlashAttribute("message", "Changes to User Profile were Successful!");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            
            return "redirect:/view_profile";
        
    }
}
