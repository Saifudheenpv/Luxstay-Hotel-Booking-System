package com.hotel.service;

import com.hotel.model.Review;
import com.hotel.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    void createReview_ShouldSaveAndReturnReview() {
        Review review = new Review();
        when(reviewRepository.save(review)).thenReturn(review);

        Review result = reviewService.createReview(review);

        assertEquals(review, result);
        verify(reviewRepository).save(review);
    }

    @Test
    void getReviewsByHotelId_ShouldReturnHotelReviews() {
        List<Review> expectedReviews = Arrays.asList(new Review(), new Review());
        when(reviewRepository.findByHotelId(1L)).thenReturn(expectedReviews);

        List<Review> result = reviewService.getReviewsByHotelId(1L);

        assertEquals(expectedReviews, result);
        verify(reviewRepository).findByHotelId(1L);
    }

    @Test
    void getReviewById_WithExistingId_ShouldReturnReview() {
        Review review = new Review();
        review.setId(1L);
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        Optional<Review> result = reviewService.getReviewById(1L);

        assertTrue(result.isPresent());
        assertEquals(review, result.get());
    }

    @Test
    void getAverageRatingForHotel_WithReviews_ShouldReturnAverage() {
        when(reviewRepository.findAverageRatingByHotelId(1L)).thenReturn(4.5);

        Double result = reviewService.getAverageRatingForHotel(1L);

        assertEquals(4.5, result);
    }

    @Test
    void getAverageRatingForHotel_WithoutReviews_ShouldReturnZero() {
        when(reviewRepository.findAverageRatingByHotelId(1L)).thenReturn(null);

        Double result = reviewService.getAverageRatingForHotel(1L);

        assertEquals(0.0, result);
    }

    @Test
    void getReviewCountForHotel_ShouldReturnCount() {
        when(reviewRepository.countReviewsByHotelId(1L)).thenReturn(5L);

        Long result = reviewService.getReviewCountForHotel(1L);

        assertEquals(5L, result);
    }

    @Test
    void hasUserReviewedBooking_ShouldReturnTrueWhenExists() {
        when(reviewRepository.existsByBookingId(1L)).thenReturn(true);

        boolean result = reviewService.hasUserReviewedBooking(1L);

        assertTrue(result);
    }
}
