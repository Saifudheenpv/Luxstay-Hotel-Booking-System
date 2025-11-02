package com.hotel.repository;

import com.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(String city);
    List<Hotel> findByCountry(String country);
    
    @Query("SELECT h FROM Hotel h WHERE h.name LIKE %:name%")
    List<Hotel> findByNameContaining(@Param("name") String name);
    
    @Query("SELECT DISTINCT h.city FROM Hotel h")
    List<String> findAllCities();
    
    List<Hotel> findByStarRatingGreaterThanEqual(Integer starRating);
}
