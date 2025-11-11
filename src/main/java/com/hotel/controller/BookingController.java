package com.hotel.controller;

import com.hotel.model.Booking;
import com.hotel.model.Hotel;
import com.hotel.model.Room;
import com.hotel.model.User;
import com.hotel.service.BookingService;
import com.hotel.service.HotelService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired private BookingService bookingService;
    @Autowired private HotelService hotelService;
    @Autowired private RoomService roomService;
    @Autowired private UserService userService;

    @Transactional(readOnly = true)
    @GetMapping("/new/{roomId}")
    public String showBookingForm(@PathVariable Long roomId,
                                  @RequestParam(required = false) Long hotelId,
                                  Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/auth/login";
        }

        Optional<Room> roomOpt = roomService.getRoomById(roomId);
        if (roomOpt.isEmpty()) {
            return "redirect:/hotels";
        }

        Room room = roomOpt.get();

        // ✅ Fetch hotel eagerly (no LazyInitializationException)
        Hotel hotel = hotelService.getHotelById(
                hotelId != null ? hotelId : room.getHotel().getId()
        ).orElse(room.getHotel());

        model.addAttribute("room", room);
        model.addAttribute("hotel", hotel);

        // Default booking details
        Booking booking = new Booking();
        booking.setCheckInDate(LocalDate.now().plusDays(1));
        booking.setCheckOutDate(LocalDate.now().plusDays(2));
        booking.setGuests(1);

        model.addAttribute("booking", booking);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("minDate", LocalDate.now().plusDays(1).format(formatter));
        model.addAttribute("checkInDate", booking.getCheckInDate().format(formatter));
        model.addAttribute("checkOutDate", booking.getCheckOutDate().format(formatter));

        userService.findById(userId).ifPresent(u -> model.addAttribute("currentUser", u));
        return "booking-form";
    }

    @PostMapping("/create")
    public String createBooking(@RequestParam Long roomId,
                                @RequestParam Long hotelId,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate,
                                @RequestParam Integer guests,
                                @RequestParam(required = false) String specialRequests,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/auth/login";

        try {
            Optional<User> userOpt = userService.findById(userId);
            Optional<Room> roomOpt = roomService.getRoomById(roomId);
            Optional<Hotel> hotelOpt = hotelService.getHotelById(hotelId);

            if (userOpt.isPresent() && roomOpt.isPresent() && hotelOpt.isPresent()) {
                Booking booking = new Booking();
                booking.setCheckInDate(checkInDate);
                booking.setCheckOutDate(checkOutDate);
                booking.setGuests(guests);
                booking.setSpecialRequests(specialRequests);
                booking.setUser(userOpt.get());
                booking.setRoom(roomOpt.get());
                booking.setHotel(hotelOpt.get());

                if (checkInDate.isBefore(LocalDate.now())) {
                    redirectAttributes.addFlashAttribute("error", "Check-in date cannot be in the past");
                    return "redirect:/bookings/new/" + roomId + "?hotelId=" + hotelId;
                }

                if (!checkOutDate.isAfter(checkInDate)) {
                    redirectAttributes.addFlashAttribute("error", "Check-out date must be after check-in date");
                    return "redirect:/bookings/new/" + roomId + "?hotelId=" + hotelId;
                }

                if (!bookingService.isRoomAvailable(roomId, checkInDate, checkOutDate)) {
                    redirectAttributes.addFlashAttribute("error", "Room is not available for those dates");
                    return "redirect:/bookings/new/" + roomId + "?hotelId=" + hotelId;
                }

                Booking savedBooking = bookingService.createBooking(booking);
                redirectAttributes.addFlashAttribute("success", "Booking confirmed successfully!");
                return "redirect:/bookings/confirmation/" + savedBooking.getId();
            } else {
                redirectAttributes.addFlashAttribute("error", "Invalid booking details");
                return "redirect:/hotels";
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error creating booking: " + e.getMessage());
            return "redirect:/bookings/new/" + roomId + "?hotelId=" + hotelId;
        }
    }

    @GetMapping("/confirmation/{id}")
    public String bookingConfirmation(@PathVariable Long id, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/auth/login";

        bookingService.getBookingById(id).ifPresent(booking -> {
            model.addAttribute("booking", booking);
            long nights = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
            model.addAttribute("bookingDuration", nights);
        });

        userService.findById(userId).ifPresent(u -> model.addAttribute("currentUser", u));
        return "booking-confirmation";
    }

    @GetMapping("/my-bookings")
    public String getMyBookings(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/auth/login";

        model.addAttribute("bookings", bookingService.getBookingsByUserId(userId));
        userService.findById(userId).ifPresent(u -> model.addAttribute("currentUser", u));

        return "my-bookings";
    }

    @PostMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) return "redirect:/auth/login";

        try {
            bookingService.cancelBooking(id);
            redirectAttributes.addFlashAttribute("success", "Booking cancelled successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error cancelling booking");
        }

        return "redirect:/bookings/my-bookings";
    }
}
