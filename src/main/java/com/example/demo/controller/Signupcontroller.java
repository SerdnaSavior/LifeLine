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
@RequestMapping("/signup")
public class Signupcontroller {
    @Autowired
    private UserServiceImpl userServiceImpl;
            
    @GetMapping()
    public String addNewUser(Model model) {
        Users user = new Users();
        model.addAttribute("newUser", user);
        return "signup";
    } 

    @PostMapping()
    public String saveUser(@ModelAttribute("newUser") Users user,RedirectAttributes redirectAttributes) {

        if (userServiceImpl.usernameExists(user.getUsername())){
        redirectAttributes.addFlashAttribute("message", "Username already taken.");
        redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/signup"; // Redirect back to the signup page
        }
        if (userServiceImpl.emailExists(user.getEmail())){
            redirectAttributes.addFlashAttribute("message", "Email already taken.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
                return "redirect:/signup"; // Redirect back to the signup page
            }



        userServiceImpl.save(user);
        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
      
        return "redirect:/login";
    }
}
