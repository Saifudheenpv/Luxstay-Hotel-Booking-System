package com.hotel.controller;

import com.hotel.model.Hotel;
import com.hotel.model.User;
import com.hotel.service.HotelService;
import com.hotel.service.ReviewService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    @Mock
    private RoomService roomService;

    @Mock
    private UserService userService;

    @Mock
    private ReviewService reviewService;

    @Mock
    private Model model;

    @Mock
    private HttpSession session;

    @InjectMocks
    private HotelController hotelController;

    @Test
    void getAllHotels_ShouldReturnHotelsView() {
        when(session.getAttribute("userId")).thenReturn(null);

        String result = hotelController.getAllHotels(model, session);

        assertEquals("hotels", result);
        verify(hotelService).getAllHotels();
        verify(hotelService).getAllCities();
    }

    @Test
    void getHotelById_WithValidHotel_ShouldReturnHotelRoomsView() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Test Hotel");

        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(hotel));
        when(session.getAttribute("userId")).thenReturn(null);

        String result = hotelController.getHotelById(1L, model, session);

        assertEquals("hotel-rooms", result);
        verify(model).addAttribute("hotel", hotel);
        verify(roomService).getAvailableRoomsByHotelId(1L);
        verify(reviewService).getReviewsByHotelId(1L);
    }

    @Test
    void searchHotels_WithQuery_ShouldReturnFilteredHotels() {
        when(session.getAttribute("userId")).thenReturn(null);
        when(hotelService.searchHotels("test")).thenReturn(Arrays.asList(new Hotel()));

        String result = hotelController.searchHotels("test", null, model, session);

        assertEquals("hotels", result);
        verify(hotelService).searchHotels("test");
    }

    @Test
    void searchHotels_WithCity_ShouldReturnCityHotels() {
        when(session.getAttribute("userId")).thenReturn(null);
        when(hotelService.getHotelsByCity("New York")).thenReturn(Arrays.asList(new Hotel()));

        String result = hotelController.searchHotels(null, "New York", model, session);

        assertEquals("hotels", result);
        verify(hotelService).getHotelsByCity("New York");
    }

    @Test
    void getHotelsByCity_ShouldReturnCityHotels() {
        when(session.getAttribute("userId")).thenReturn(null);

        String result = hotelController.getHotelsByCity("New York", model, session);

        assertEquals("hotels", result);
        verify(hotelService).getHotelsByCity("New York");
    }
}
