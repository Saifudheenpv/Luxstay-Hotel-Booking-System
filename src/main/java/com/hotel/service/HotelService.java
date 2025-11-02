package com.hotel.service;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;
    
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }
    
    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.findByCity(city);
    }
    
    public List<Hotel> searchHotels(String query) {
        return hotelRepository.findByNameContaining(query);
    }
    
    public List<String> getAllCities() {
        return hotelRepository.findAllCities();
    }
    
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
