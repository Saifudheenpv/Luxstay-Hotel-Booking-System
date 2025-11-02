package com.hotel.service;

import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private RoomService roomService;
    
    public Booking createBooking(Booking booking) {
        // Calculate total price
        long nights = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        double totalPrice = nights * booking.getRoom().getPrice();
        booking.setTotalPrice(totalPrice);
        booking.setStatus("CONFIRMED");
        
        return bookingRepository.save(booking);
    }
    
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
    
    public boolean isRoomAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        List<Booking> conflicts = bookingRepository.findConflictingBookings(roomId, checkIn, checkOut);
        return conflicts.isEmpty();
    }
    
    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus("CANCELLED");
            bookingRepository.save(booking);
        }
    }
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
