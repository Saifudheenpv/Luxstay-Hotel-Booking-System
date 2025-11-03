package com.hotel.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void userDTO_ShouldHaveCorrectGettersAndSetters() {
        UserDTO dto = new UserDTO();
        
        dto.setId(1L);
        dto.setUsername("testuser");
        dto.setEmail("test@example.com");
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setPhone("1234567890");
        dto.setAddress("Test Address");
        
        assertEquals(1L, dto.getId());
        assertEquals("testuser", dto.getUsername());
        assertEquals("test@example.com", dto.getEmail());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("1234567890", dto.getPhone());
        assertEquals("Test Address", dto.getAddress());
    }

    @Test
    void userDTO_Constructor_ShouldSetAllFields() {
        UserDTO dto = new UserDTO(1L, "testuser", "test@example.com", 
                                 "John", "Doe", "1234567890", "Test Address");
        
        assertEquals(1L, dto.getId());
        assertEquals("testuser", dto.getUsername());
        assertEquals("test@example.com", dto.getEmail());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("1234567890", dto.getPhone());
        assertEquals("Test Address", dto.getAddress());
    }
}
