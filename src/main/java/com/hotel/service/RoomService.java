package com.hotel.service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
    
    public List<Room> getAvailableRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelIdAndAvailableTrue(hotelId);
    }
    
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
    
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    
    public List<Room> getAvailableRoomsByHotelAndGuests(Long hotelId, Integer guests) {
        return roomRepository.findAvailableRoomsByHotelAndGuests(hotelId, guests);
    }
}
