package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.service.BookingService;
import com.hotel.service.HotelService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private HotelService hotelService;
    
    @GetMapping
    public String viewProfile(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }
        
        Optional<User> userOpt = userService.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            model.addAttribute("user", user);
            model.addAttribute("currentUser", user);
            
            // Add statistics
            model.addAttribute("bookings", bookingService.getBookingsByUserId(userId));
            model.addAttribute("hotels", hotelService.getAllHotels());
            
            return "profile";
        } else {
            return "redirect:/auth/login";
        }
    }
    
    @PostMapping("/update")
    public String updateProfile(@ModelAttribute User userDetails,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }
        
        try {
            Optional<User> existingUserOpt = userService.findById(userId);
            if (existingUserOpt.isPresent()) {
                User existingUser = existingUserOpt.get();
                
                // Update only allowed fields
                existingUser.setFirstName(userDetails.getFirstName());
                existingUser.setLastName(userDetails.getLastName());
                existingUser.setEmail(userDetails.getEmail());
                existingUser.setPhone(userDetails.getPhone());
                existingUser.setAddress(userDetails.getAddress());
                
                userService.updateUser(existingUser);
                redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating profile: " + e.getMessage());
        }
        
        return "redirect:/profile";
    }
}
