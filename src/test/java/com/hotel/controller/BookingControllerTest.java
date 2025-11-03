package com.hotel.controller;

import com.hotel.model.Booking;
import com.hotel.model.User;
import com.hotel.model.Room;
import com.hotel.model.Hotel;
import com.hotel.service.BookingService;
import com.hotel.service.HotelService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @Mock
    private HotelService hotelService;

    @Mock
    private RoomService roomService;

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private HttpSession session;

    @InjectMocks
    private BookingController bookingController;

    private User user;
    private Room room;
    private Hotel hotel;
    private Booking booking;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setFirstName("John");

        hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Test Hotel");

        room = new Room();
        room.setId(1L);
        room.setHotel(hotel);
        room.setPrice(100.0);

        booking = new Booking();
        booking.setId(1L);
        booking.setUser(user);
        booking.setRoom(room);
        booking.setHotel(hotel);
        booking.setCheckInDate(LocalDate.now().plusDays(1));
        booking.setCheckOutDate(LocalDate.now().plusDays(3));
        booking.setGuests(2);
        booking.setTotalPrice(200.0);
    }

    @Test
    void showBookingForm_WithValidUser_ShouldReturnBookingForm() {
        when(session.getAttribute("userId")).thenReturn(1L);
        when(roomService.getRoomById(1L)).thenReturn(Optional.of(room));
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        String result = bookingController.showBookingForm(1L, 1L, model, session);

        assertEquals("booking-form", result);
        verify(model).addAttribute(eq("room"), any(Room.class));
        verify(model).addAttribute(eq("hotel"), any(Hotel.class));
        verify(model).addAttribute(eq("booking"), any(Booking.class));
    }

    @Test
    void showBookingForm_WithoutUser_ShouldRedirectToLogin() {
        when(session.getAttribute("userId")).thenReturn(null);

        String result = bookingController.showBookingForm(1L, 1L, model, session);

        assertEquals("redirect:/auth/login", result);
    }

    @Test
    void createBooking_WithValidData_ShouldCreateBooking() {
        when(session.getAttribute("userId")).thenReturn(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));
        when(roomService.getRoomById(1L)).thenReturn(Optional.of(room));
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(hotel));
        when(bookingService.isRoomAvailable(anyLong(), any(LocalDate.class), any(LocalDate.class))).thenReturn(true);
        when(bookingService.createBooking(any(Booking.class))).thenReturn(booking);

        String result = bookingController.createBooking(
            1L, 1L, LocalDate.now().plusDays(1), LocalDate.now().plusDays(3),
            2, "Special requests", session, redirectAttributes
        );

        assertEquals("redirect:/bookings/confirmation/1", result);
        verify(redirectAttributes).addFlashAttribute("success", "Booking confirmed successfully!");
    }

    @Test
    void createBooking_WithPastCheckInDate_ShouldReturnError() {
        when(session.getAttribute("userId")).thenReturn(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));
        when(roomService.getRoomById(1L)).thenReturn(Optional.of(room));
        when(hotelService.getHotelById(1L)).thenReturn(Optional.of(hotel));

        String result = bookingController.createBooking(
            1L, 1L, LocalDate.now().minusDays(1), LocalDate.now().plusDays(2),
            2, "", session, redirectAttributes
        );

        assertEquals("redirect:/bookings/new/1?hotelId=1", result);
        verify(redirectAttributes).addFlashAttribute("error", "Check-in date cannot be in the past");
    }

    @Test
    void bookingConfirmation_WithValidBooking_ShouldShowConfirmation() {
        when(session.getAttribute("userId")).thenReturn(1L);
        when(bookingService.getBookingById(1L)).thenReturn(Optional.of(booking));
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        String result = bookingController.bookingConfirmation(1L, model, session);

        assertEquals("booking-confirmation", result);
        verify(model).addAttribute(eq("booking"), any(Booking.class));
        verify(model).addAttribute(eq("bookingDuration"), any(Long.class));
    }

    @Test
    void getMyBookings_ShouldReturnUserBookings() {
        when(session.getAttribute("userId")).thenReturn(1L);
        when(userService.findById(1L)).thenReturn(Optional.of(user));

        String result = bookingController.getMyBookings(model, session);

        assertEquals("my-bookings", result);
        verify(bookingService).getBookingsByUserId(1L);
    }

    @Test
    void cancelBooking_ShouldCancelSuccessfully() {
        when(session.getAttribute("userId")).thenReturn(1L);

        String result = bookingController.cancelBooking(1L, session, redirectAttributes);

        assertEquals("redirect:/bookings/my-bookings", result);
        verify(bookingService).cancelBooking(1L);
        verify(redirectAttributes).addFlashAttribute("success", "Booking cancelled successfully");
    }
}
