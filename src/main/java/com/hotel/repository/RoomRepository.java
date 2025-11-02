package com.hotel.repository;

import com.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
    List<Room> findByHotelIdAndAvailableTrue(Long hotelId);
    List<Room> findByTypeAndAvailableTrue(String type);
    
    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId AND r.available = true AND r.capacity >= :guests")
    List<Room> findAvailableRoomsByHotelAndGuests(@Param("hotelId") Long hotelId, @Param("guests") Integer guests);
}
