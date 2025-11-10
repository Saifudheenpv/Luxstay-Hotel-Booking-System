package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.service.BookingService;
import com.hotel.service.HotelService;
import com.hotel.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @Mock
    private HotelService hotelService;

    @Mock
    private UserService userService;

    @Mock
    private BookingService bookingService;

    @Mock
    private Model model;

    @Mock
    private HttpSession session;

    @InjectMocks
    private HomeController homeController;

    @Test
    void home_WithLoggedInUser_ShouldAddUserToModel() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        when(session.getAttribute("userId")).thenReturn(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        String result = homeController.home(model, session);

        assertEquals("index", result);
        verify(model).addAttribute(eq("currentUser"), any(User.class));
        verify(hotelService).getAllHotels();
        verify(hotelService).getAllCities();
    }

    @Test
    void home_WithoutUser_ShouldNotAddUserToModel() {
        when(session.getAttribute("userId")).thenReturn(null);

        String result = homeController.home(model, session);

        assertEquals("index", result);
        verify(model, never()).addAttribute(eq("currentUser"), any());
    }

    @Test
    void about_WithLoggedInUser_ShouldAddUserToModel() {
        User user = new User();
        user.setId(1L);

        when(session.getAttribute("userId")).thenReturn(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        String result = homeController.about(session, model);

        assertEquals("about", result);
        verify(model).addAttribute(eq("currentUser"), any(User.class));
    }

    @Test
    void contact_WithLoggedInUser_ShouldAddUserToModel() {
        User user = new User();
        user.setId(1L);

        when(session.getAttribute("userId")).thenReturn(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        String result = homeController.contact(session, model);

        assertEquals("contact", result);
        verify(model).addAttribute(eq("currentUser"), any(User.class));
    }
}
