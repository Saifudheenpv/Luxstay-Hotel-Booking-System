package com.hotel.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfileUpdateDTOTest {

    @Test
    void profileUpdateDTO_ShouldHaveCorrectGettersAndSetters() {
        ProfileUpdateDTO dto = new ProfileUpdateDTO();
        
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setEmail("test@example.com");
        dto.setPhone("1234567890");
        dto.setAddress("Test Address");
        
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("test@example.com", dto.getEmail());
        assertEquals("1234567890", dto.getPhone());
        assertEquals("Test Address", dto.getAddress());
    }
}
