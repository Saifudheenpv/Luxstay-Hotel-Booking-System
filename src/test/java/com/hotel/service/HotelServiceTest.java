package com.hotel.service;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;
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
class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    @Test
    void getAllHotels_ShouldReturnAllHotels() {
        List<Hotel> expectedHotels = Arrays.asList(new Hotel(), new Hotel());
        when(hotelRepository.findAll()).thenReturn(expectedHotels);

        List<Hotel> result = hotelService.getAllHotels();

        assertEquals(expectedHotels, result);
        verify(hotelRepository).findAll();
    }

    @Test
    void getHotelById_WithExistingId_ShouldReturnHotel() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));

        Optional<Hotel> result = hotelService.getHotelById(1L);

        assertTrue(result.isPresent());
        assertEquals(hotel, result.get());
    }

    @Test
    void getHotelById_WithNonExistingId_ShouldReturnEmpty() {
        when(hotelRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Hotel> result = hotelService.getHotelById(999L);

        assertFalse(result.isPresent());
    }

    @Test
    void getHotelsByCity_ShouldReturnCityHotels() {
        List<Hotel> expectedHotels = Arrays.asList(new Hotel());
        when(hotelRepository.findByCity("New York")).thenReturn(expectedHotels);

        List<Hotel> result = hotelService.getHotelsByCity("New York");

        assertEquals(expectedHotels, result);
        verify(hotelRepository).findByCity("New York");
    }

    @Test
    void searchHotels_ShouldReturnMatchingHotels() {
        List<Hotel> expectedHotels = Arrays.asList(new Hotel());
        when(hotelRepository.findByNameContaining("test")).thenReturn(expectedHotels);

        List<Hotel> result = hotelService.searchHotels("test");

        assertEquals(expectedHotels, result);
        verify(hotelRepository).findByNameContaining("test");
    }

    @Test
    void getAllCities_ShouldReturnAllCities() {
        List<String> expectedCities = Arrays.asList("New York", "London");
        when(hotelRepository.findAllCities()).thenReturn(expectedCities);

        List<String> result = hotelService.getAllCities();

        assertEquals(expectedCities, result);
        verify(hotelRepository).findAllCities();
    }

    @Test
    void saveHotel_ShouldSaveAndReturnHotel() {
        Hotel hotel = new Hotel();
        when(hotelRepository.save(hotel)).thenReturn(hotel);

        Hotel result = hotelService.saveHotel(hotel);

        assertEquals(hotel, result);
        verify(hotelRepository).save(hotel);
    }
}
