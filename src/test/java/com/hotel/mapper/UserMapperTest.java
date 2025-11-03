package com.hotel.mapper;

import com.hotel.dto.UserDTO;
import com.hotel.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper = new UserMapper();

    @Test
    void toDTO_WithValidUser_ShouldReturnUserDTO() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPhone("1234567890");
        user.setAddress("Test Address");

        UserDTO result = userMapper.toDTO(user);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("testuser", result.getUsername());
        assertEquals("test@example.com", result.getEmail());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("1234567890", result.getPhone());
        assertEquals("Test Address", result.getAddress());
    }

    @Test
    void toDTO_WithNullUser_ShouldReturnNull() {
        UserDTO result = userMapper.toDTO(null);
        assertNull(result);
    }
}
