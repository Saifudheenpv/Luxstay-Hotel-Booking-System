package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.service.BookingService;
import com.hotel.service.HotelService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class HomeController {
    
    @Autowired
    private HotelService hotelService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookingService bookingService;
    
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("cities", hotelService.getAllCities());
        
        // Check if user is logged in
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        
        return "index";
    }
    
    @GetMapping("/about")
    public String about(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        return "about";
    }
    
    @GetMapping("/contact")
    public String contact(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        return "contact";
    }
}
