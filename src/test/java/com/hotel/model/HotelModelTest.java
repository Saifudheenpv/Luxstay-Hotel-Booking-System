package com.hotel.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelModelTest {

    @Test
    public void testHotelCreation() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Test Hotel");
        hotel.setCity("Test City");
        hotel.setCountry("Test Country");

        assertEquals(1L, hotel.getId());
        assertEquals("Test Hotel", hotel.getName());
        assertEquals("Test City", hotel.getCity());
        assertEquals("Test Country", hotel.getCountry());
    }

    @Test
    public void testHotelRating() {
        Hotel hotel = new Hotel();
        hotel.setRating(4.5);
        hotel.setStarRating(5);

        assertEquals(4.5, hotel.getRating());
        assertEquals(5, hotel.getStarRating());
    }
}
