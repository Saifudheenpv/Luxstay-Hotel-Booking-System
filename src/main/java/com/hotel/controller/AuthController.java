package com.hotel.controller;

import com.hotel.dto.UserRegistrationDTO;
import com.hotel.model.User;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserRegistrationDTO userRegistrationDTO,
                              @RequestParam String confirmPassword,
                              RedirectAttributes redirectAttributes) {
        try {
            if (!userRegistrationDTO.getPassword().equals(confirmPassword)) {
                redirectAttributes.addFlashAttribute("error", "Passwords do not match");
                return "redirect:/auth/register";
            }
            
            // Convert DTO to Entity
            User user = new User();
            user.setUsername(userRegistrationDTO.getUsername());
            user.setEmail(userRegistrationDTO.getEmail());
            user.setPassword(userRegistrationDTO.getPassword());
            user.setFirstName(userRegistrationDTO.getFirstName());
            user.setLastName(userRegistrationDTO.getLastName());
            user.setPhone(userRegistrationDTO.getPhone());
            user.setAddress(userRegistrationDTO.getAddress());
            
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("success", "Registration successful! Please login.");
            return "redirect:/auth/login";
            
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/auth/register";
        }
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                           @RequestParam String password,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {
        Optional<User> userOpt = userService.authenticate(username, password);
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Store only necessary info in session, not the entire entity
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userFirstName", user.getFirstName());
            redirectAttributes.addFlashAttribute("success", "Welcome back, " + user.getFirstName() + "!");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/auth/login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("success", "You have been logged out successfully");
        return "redirect:/";
    }
}
