package com.hotel.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimplePasswordEncoderTest {

    private SimplePasswordEncoder passwordEncoder = new SimplePasswordEncoder();

    @Test
    void encode_ShouldReturnConsistentHash() {
        String password = "testPassword123";
        String encoded1 = passwordEncoder.encode(password);
        String encoded2 = passwordEncoder.encode(password);

        assertNotNull(encoded1);
        assertNotNull(encoded2);
        assertEquals(encoded1, encoded2);
        assertNotEquals(password, encoded1);
    }

    @Test
    void matches_WithCorrectPassword_ShouldReturnTrue() {
        String password = "testPassword123";
        String encoded = passwordEncoder.encode(password);

        assertTrue(passwordEncoder.matches(password, encoded));
    }

    @Test
    void matches_WithIncorrectPassword_ShouldReturnFalse() {
        String password = "testPassword123";
        String wrongPassword = "wrongPassword";
        String encoded = passwordEncoder.encode(password);

        assertFalse(passwordEncoder.matches(wrongPassword, encoded));
    }

    @Test
    void matches_WithDifferentEncodedPassword_ShouldReturnFalse() {
        String password = "testPassword123";
        String encoded1 = passwordEncoder.encode(password);
        String encoded2 = passwordEncoder.encode("differentPassword");

        assertFalse(passwordEncoder.matches(password, encoded2));
    }
}
