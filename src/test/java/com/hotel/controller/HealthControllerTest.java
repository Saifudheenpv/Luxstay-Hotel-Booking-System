package com.hotel.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.health.Health;

import static org.junit.jupiter.api.Assertions.*;

class HealthControllerTest {

    private HealthController healthController = new HealthController();

    @Test
    void simpleHealth_ShouldReturnOK() {
        String result = healthController.simpleHealth();
        assertEquals("OK", result);
    }

    @Test
    void info_ShouldReturnVersionInfo() {
        String result = healthController.info();
        assertEquals("Hotel Booking System - Version 1.0.0", result);
    }

    @Test
    void health_ShouldReturnUpStatus() {
        Health result = healthController.health();
        assertNotNull(result);
        assertEquals(Health.up().build().getStatus(), result.getStatus());
    }
}
