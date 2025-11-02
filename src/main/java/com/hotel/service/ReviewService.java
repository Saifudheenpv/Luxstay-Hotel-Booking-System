package com.hotel.service;

import com.hotel.model.Review;
import com.hotel.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
    
    public List<Review> getReviewsByHotelId(Long hotelId) {
        return reviewRepository.findByHotelId(hotelId);
    }
    
    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
    
    public Double getAverageRatingForHotel(Long hotelId) {
        Double avg = reviewRepository.findAverageRatingByHotelId(hotelId);
        return avg != null ? Math.round(avg * 10.0) / 10.0 : 0.0;
    }
    
    public Long getReviewCountForHotel(Long hotelId) {
        return reviewRepository.countReviewsByHotelId(hotelId);
    }
    
    public boolean hasUserReviewedBooking(Long bookingId) {
        return reviewRepository.existsByBookingId(bookingId);
    }
}
