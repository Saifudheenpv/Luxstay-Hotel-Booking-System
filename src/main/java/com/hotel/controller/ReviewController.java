package com.hotel.controller;

import com.hotel.model.Review;
import com.hotel.model.User;
import com.hotel.service.BookingService;
import com.hotel.service.ReviewService;
import com.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    
    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookingService bookingService;
    
    @PostMapping("/create")
    public String createReview(@RequestParam Long bookingId,
                             @RequestParam Long hotelId,
                             @RequestParam Integer rating,
                             @RequestParam String comment,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }
        
        try {
            Optional<User> userOpt = userService.findById(userId);
            if (userOpt.isPresent() && reviewService.hasUserReviewedBooking(bookingId)) {
                redirectAttributes.addFlashAttribute("error", "You have already reviewed this booking");
                return "redirect:/bookings/my-bookings";
            }
            
            if (userOpt.isPresent()) {
                Review review = new Review();
                review.setRating(rating);
                review.setComment(comment);
                review.setUser(userOpt.get());
                bookingService.getBookingById(bookingId).ifPresent(review::setBooking);
                // Hotel will be set automatically through the booking
                
                reviewService.createReview(review);
                redirectAttributes.addFlashAttribute("success", "Thank you for your review!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error submitting review: " + e.getMessage());
        }
        
        return "redirect:/bookings/my-bookings";
    }
}
