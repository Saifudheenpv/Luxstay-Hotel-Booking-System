package com.hotel.service;

import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private BookingService bookingService;

    private Booking booking;
    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room();
        room.setId(1L);
        room.setPrice(100.0);

        booking = new Booking();
        booking.setId(1L);
        booking.setRoom(room);
        booking.setCheckInDate(LocalDate.now().plusDays(1));
        booking.setCheckOutDate(LocalDate.now().plusDays(3));
        booking.setGuests(2);
    }

    @Test
    void createBooking_ShouldCalculateTotalPriceAndSave() {
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking result = bookingService.createBooking(booking);

        assertNotNull(result);
        assertEquals(200.0, result.getTotalPrice());
        assertEquals("CONFIRMED", result.getStatus());
        verify(bookingRepository).save(booking);
    }

    @Test
    void getBookingsByUserId_ShouldReturnUserBookings() {
        List<Booking> expectedBookings = Arrays.asList(booking);
        when(bookingRepository.findByUserId(1L)).thenReturn(expectedBookings);

        List<Booking> result = bookingService.getBookingsByUserId(1L);

        assertEquals(expectedBookings, result);
        verify(bookingRepository).findByUserId(1L);
    }

    @Test
    void getBookingById_ShouldReturnBooking() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Optional<Booking> result = bookingService.getBookingById(1L);

        assertTrue(result.isPresent());
        assertEquals(booking, result.get());
    }

    @Test
    void isRoomAvailable_WithNoConflicts_ShouldReturnTrue() {
        when(bookingRepository.findConflictingBookings(anyLong(), any(LocalDate.class), any(LocalDate.class)))
                .thenReturn(Arrays.asList());

        boolean result = bookingService.isRoomAvailable(1L, LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));

        assertTrue(result);
    }

    @Test
    void isRoomAvailable_WithConflicts_ShouldReturnFalse() {
        when(bookingRepository.findConflictingBookings(anyLong(), any(LocalDate.class), any(LocalDate.class)))
                .thenReturn(Arrays.asList(booking));

        boolean result = bookingService.isRoomAvailable(1L, LocalDate.now().plusDays(1), LocalDate.now().plusDays(3));

        assertFalse(result);
    }

    @Test
    void cancelBooking_ShouldUpdateStatus() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        bookingService.cancelBooking(1L);

        assertEquals("CANCELLED", booking.getStatus());
        verify(bookingRepository).save(booking);
    }

    @Test
    void getAllBookings_ShouldReturnAllBookings() {
        List<Booking> expectedBookings = Arrays.asList(booking);
        when(bookingRepository.findAll()).thenReturn(expectedBookings);

        List<Booking> result = bookingService.getAllBookings();

        assertEquals(expectedBookings, result);
        verify(bookingRepository).findAll();
    }
}
