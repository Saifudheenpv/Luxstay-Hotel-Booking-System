package com.hotel.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimplePasswordEncoderTest {

    private SimplePasswordEncoder passwordEncoder = new SimplePasswordEncoder();

    @Test
    public void testEncodePassword() {
        String password = "testpassword";
        String encoded = passwordEncoder.encode(password);
        
        assertNotNull(encoded);
        assertNotEquals(password, encoded);
        assertTrue(encoded.length() > 0);
    }

    @Test
    public void testMatches_Success() {
        String password = "testpassword";
        String encoded = passwordEncoder.encode(password);
        
        assertTrue(passwordEncoder.matches(password, encoded));
    }

    @Test
    public void testMatches_Failure() {
        String password = "testpassword";
        String wrongPassword = "wrongpassword";
        String encoded = passwordEncoder.encode(password);
        
        assertFalse(passwordEncoder.matches(wrongPassword, encoded));
    }
}
