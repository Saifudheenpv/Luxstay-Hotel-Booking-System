package com.hotel.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthIndicator {

    @GetMapping("/health")
    public String simpleHealth() {
        return "OK";
    }

    @GetMapping("/actuator/info")
    public String info() {
        return "Hotel Booking System - Version 1.0.0";
    }

    @Override
    public Health health() {
        try {
            // Add custom health checks here
            // You can check database connectivity, external services, etc.
            return Health.up()
                    .withDetail("service", "Hotel Booking System")
                    .withDetail("status", "UP")
                    .withDetail("version", "1.0.0")
                    .build();
        } catch (Exception e) {
            return Health.down(e)
                    .withDetail("service", "Hotel Booking System")
                    .withDetail("error", e.getMessage())
                    .build();
        }
    }
}
