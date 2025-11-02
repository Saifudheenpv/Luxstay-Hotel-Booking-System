package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.service.HotelService;
import com.hotel.service.ReviewService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;
    
    @GetMapping
    public String getAllHotels(Model model, HttpSession session) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("cities", hotelService.getAllCities());
        model.addAttribute("selectedCity", "");
        model.addAttribute("searchQuery", "");
        
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        
        return "hotels";
    }
    
    @GetMapping("/{id}")
    public String getHotelById(@PathVariable Long id, Model model, HttpSession session) {
        hotelService.getHotelById(id).ifPresent(hotel -> {
            model.addAttribute("hotel", hotel);
            model.addAttribute("rooms", roomService.getAvailableRoomsByHotelId(id));
            model.addAttribute("reviews", reviewService.getReviewsByHotelId(id));
            model.addAttribute("averageRating", reviewService.getAverageRatingForHotel(id));
            model.addAttribute("reviewCount", reviewService.getReviewCountForHotel(id));
        });
        
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        
        return "hotel-rooms";
    }
    
    @GetMapping("/search")
    public String searchHotels(@RequestParam(required = false) String query, 
                              @RequestParam(required = false) String city,
                              Model model, HttpSession session) {
        if (city != null && !city.isEmpty()) {
            model.addAttribute("hotels", hotelService.getHotelsByCity(city));
        } else if (query != null && !query.isEmpty()) {
            model.addAttribute("hotels", hotelService.searchHotels(query));
        } else {
            model.addAttribute("hotels", hotelService.getAllHotels());
        }
        
        model.addAttribute("cities", hotelService.getAllCities());
        model.addAttribute("searchQuery", query != null ? query : "");
        model.addAttribute("selectedCity", city != null ? city : "");
        
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        
        return "hotels";
    }
    
    @GetMapping("/city/{city}")
    public String getHotelsByCity(@PathVariable String city, Model model, HttpSession session) {
        model.addAttribute("hotels", hotelService.getHotelsByCity(city));
        model.addAttribute("cities", hotelService.getAllCities());
        model.addAttribute("selectedCity", city);
        model.addAttribute("searchQuery", "");
        
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            Optional<User> userOpt = userService.findById(userId);
            userOpt.ifPresent(user -> model.addAttribute("currentUser", user));
        }
        
        return "hotels";
    }
}
