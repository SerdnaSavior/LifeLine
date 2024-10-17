package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

import com.example.demo.model.Users;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserServiceImpl;






@Controller
@RequestMapping()
public class Logincontroller {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("alluserlist", userServiceImpl.getAllUsers());
        return "login";
    } 

    // @GetMapping("/islogin")
    // public String islogin(HttpSession session) {
    //     Users currentUser = (Users) session.getAttribute("currentUser");
    //     // If user is not logged in, redirect to the login page
    //     if (currentUser == null) {
    //         return "redirect:/login";
    //     }
    //     return "";        
    // }
    

    @PostMapping("/login")
    public String login( @RequestParam String username,
            @RequestParam String password, RedirectAttributes redirectAttributes,HttpSession session) {
        
        // check if username exists in database and password matches 
        Users user = userRepository.findByUsername(username)
        .orElse(null);   

        
        if (user == null || (!password.matches(user.getPassword()) )) {                       
            redirectAttributes.addFlashAttribute("message", "Username or Password Invalid ");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/login"; // Redirect back to the signup page
        }

        

        if(user.getRole().equals("ADMIN")){
           // Store the user in the session if authenticated
            session.setAttribute("currentUser", user);
            
            redirectAttributes.addFlashAttribute("message", "Login Successful! Welcome " + username);
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            redirectAttributes.addFlashAttribute("username", username);

            return "redirect:/admin_dash"; 
        }

        
            // Store the user in the session if authenticated
            session.setAttribute("currentUser", user);
            
            redirectAttributes.addFlashAttribute("message", "Login Successful! Welcome " + username);
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            redirectAttributes.addFlashAttribute("username", username);
            return "redirect:/pat_dash"; 
        
         
    }
}



