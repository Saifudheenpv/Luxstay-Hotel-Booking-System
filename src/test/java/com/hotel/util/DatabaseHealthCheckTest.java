package com.hotel.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DatabaseHealthCheckTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private DatabaseHealthCheck databaseHealthCheck;

    @Test
    void isDatabaseConnected_WhenDatabaseIsUp_ShouldReturnTrue() {
        when(jdbcTemplate.queryForObject("SELECT 1", Integer.class)).thenReturn(1);

        boolean result = databaseHealthCheck.isDatabaseConnected();

        assertTrue(result);
        verify(jdbcTemplate).queryForObject("SELECT 1", Integer.class);
    }

    @Test
    void isDatabaseConnected_WhenDatabaseIsDown_ShouldReturnFalse() {
        when(jdbcTemplate.queryForObject("SELECT 1", Integer.class)).thenThrow(new RuntimeException("Connection failed"));

        boolean result = databaseHealthCheck.isDatabaseConnected();

        assertFalse(result);
        verify(jdbcTemplate).queryForObject("SELECT 1", Integer.class);
    }
}
