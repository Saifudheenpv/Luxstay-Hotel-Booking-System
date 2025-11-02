package com.hotel.repository;

import com.hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByHotelId(Long hotelId);
    List<Booking> findByRoomId(Long roomId);
    
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND b.status != 'CANCELLED' AND " +
           "((b.checkInDate BETWEEN :checkIn AND :checkOut) OR " +
           "(b.checkOutDate BETWEEN :checkIn AND :checkOut) OR " +
           "(b.checkInDate <= :checkIn AND b.checkOutDate >= :checkOut))")
    List<Booking> findConflictingBookings(@Param("roomId") Long roomId, 
                                         @Param("checkIn") LocalDate checkIn, 
                                         @Param("checkOut") LocalDate checkOut);
}
