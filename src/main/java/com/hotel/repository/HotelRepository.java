package com.hotel.repository;

import com.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCity(String city);
    List<Hotel> findByNameContaining(String query);
    
    @Query("SELECT DISTINCT h.city FROM Hotel h")
    List<String> findAllCities();

    // ✅ Eager fetch hotel by id (no lazy proxy issues)
    @Query("SELECT h FROM Hotel h WHERE h.id = :id")
    Optional<Hotel> findHotelDetailsById(@Param("id") Long id);
}
