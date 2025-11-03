package com.hotel.service;

import com.hotel.model.Room;
import com.hotel.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    void getRoomsByHotelId_ShouldReturnRooms() {
        List<Room> expectedRooms = Arrays.asList(new Room(), new Room());
        when(roomRepository.findByHotelId(1L)).thenReturn(expectedRooms);

        List<Room> result = roomService.getRoomsByHotelId(1L);

        assertEquals(expectedRooms, result);
        verify(roomRepository).findByHotelId(1L);
    }

    @Test
    void getAvailableRoomsByHotelId_ShouldReturnAvailableRooms() {
        List<Room> expectedRooms = Arrays.asList(new Room());
        when(roomRepository.findByHotelIdAndAvailableTrue(1L)).thenReturn(expectedRooms);

        List<Room> result = roomService.getAvailableRoomsByHotelId(1L);

        assertEquals(expectedRooms, result);
        verify(roomRepository).findByHotelIdAndAvailableTrue(1L);
    }

    @Test
    void getRoomById_WithExistingId_ShouldReturnRoom() {
        Room room = new Room();
        room.setId(1L);
        when(roomRepository.findById(1L)).thenReturn(Optional.of(room));

        Optional<Room> result = roomService.getRoomById(1L);

        assertTrue(result.isPresent());
        assertEquals(room, result.get());
    }

    @Test
    void saveRoom_ShouldSaveAndReturnRoom() {
        Room room = new Room();
        when(roomRepository.save(room)).thenReturn(room);

        Room result = roomService.saveRoom(room);

        assertEquals(room, result);
        verify(roomRepository).save(room);
    }

    @Test
    void getAvailableRoomsByHotelAndGuests_ShouldReturnFilteredRooms() {
        List<Room> expectedRooms = Arrays.asList(new Room());
        when(roomRepository.findAvailableRoomsByHotelAndGuests(1L, 2)).thenReturn(expectedRooms);

        List<Room> result = roomService.getAvailableRoomsByHotelAndGuests(1L, 2);

        assertEquals(expectedRooms, result);
        verify(roomRepository).findAvailableRoomsByHotelAndGuests(1L, 2);
    }
}
