package com.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class SmokeTest {

    @Test
    public void contextLoads() {
        // This test just verifies Spring context loads
        assertTrue(true);
    }

    @Test
    public void basicMathTest() {
        // Simple assertion test
        assertEquals(2, 1 + 1);
    }

    @Test
    public void applicationStarts() {
        // Test that main application can start
        assertDoesNotThrow(() -> HotelBookingApplication.main(new String[]{}));
    }
}
