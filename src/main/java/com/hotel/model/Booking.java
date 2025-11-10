package com.hotel.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "check_in_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkInDate;
    
    @Column(name = "check_out_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkOutDate;
    
    @Column(nullable = false)
    private Integer guests;
    
    @Column(nullable = false)
    private Double totalPrice;
    
    private String status;
    private String specialRequests;
    
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    // Constructors
    public Booking() {
        this.bookingDate = LocalDateTime.now();
        this.status = "PENDING";
    }
    
    public Booking(LocalDate checkInDate, LocalDate checkOutDate, Integer guests, 
                   Double totalPrice, String status, String specialRequests, 
                   User user, Hotel hotel, Room room) {
        this();
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guests = guests;
        this.totalPrice = totalPrice;
        this.status = status;
        this.specialRequests = specialRequests;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }
    
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }
    
    public Integer getGuests() { return guests; }
    public void setGuests(Integer guests) { this.guests = guests; }
    
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getSpecialRequests() { return specialRequests; }
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
    
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
    
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
