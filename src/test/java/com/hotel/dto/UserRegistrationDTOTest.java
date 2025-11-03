package com.hotel.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationDTOTest {

    @Test
    public void testUserRegistrationDTO() {
        UserRegistrationDTO dto = new UserRegistrationDTO();
        dto.setUsername("testuser");
        dto.setEmail("test@example.com");
        dto.setPassword("password123");
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setPhone("1234567890");
        dto.setAddress("Test Address");

        assertEquals("testuser", dto.getUsername());
        assertEquals("test@example.com", dto.getEmail());
        assertEquals("password123", dto.getPassword());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("1234567890", dto.getPhone());
        assertEquals("Test Address", dto.getAddress());
    }
}
