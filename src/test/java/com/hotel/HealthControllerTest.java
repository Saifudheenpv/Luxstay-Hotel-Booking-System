package com.hotel.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void healthEndpointShouldReturnOK() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/health", String.class);
        
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("OK");
    }

    @Test
    public void contextLoads() {
        // Basic context loading test
    }
}