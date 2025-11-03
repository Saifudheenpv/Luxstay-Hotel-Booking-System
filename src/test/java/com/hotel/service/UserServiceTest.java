package com.hotel.service;

import com.hotel.model.User;
import com.hotel.repository.UserRepository;
import com.hotel.util.SimplePasswordEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private SimplePasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("rawPassword");
    }

    @Test
    void registerUser_WithNewUser_ShouldSaveUser() {
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(passwordEncoder.encode("rawPassword")).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.registerUser(user);

        assertNotNull(result);
        verify(passwordEncoder).encode("rawPassword");
        verify(userRepository).save(user);
    }

    @Test
    void registerUser_WithExistingUsername_ShouldThrowException() {
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        assertThrows(RuntimeException.class, () -> userService.registerUser(user));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void authenticate_WithValidCredentials_ShouldReturnUser() {
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password", "encodedPassword")).thenReturn(true);
        user.setPassword("encodedPassword");

        Optional<User> result = userService.authenticate("testuser", "password");

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void authenticate_WithInvalidPassword_ShouldReturnEmpty() {
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongPassword", "encodedPassword")).thenReturn(false);
        user.setPassword("encodedPassword");

        Optional<User> result = userService.authenticate("testuser", "wrongPassword");

        assertFalse(result.isPresent());
    }

    @Test
    void findById_WithExistingId_ShouldReturnUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void updateUser_ShouldSaveAndReturnUser() {
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(user);

        assertEquals(user, result);
        verify(userRepository).save(user);
    }

    @Test
    void existsByUsername_ShouldReturnTrueWhenExists() {
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        boolean result = userService.existsByUsername("testuser");

        assertTrue(result);
    }

    @Test
    void findAll_ShouldReturnAllUsers() {
        List<User> expectedUsers = Arrays.asList(user, new User());
        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> result = userService.findAll();

        assertEquals(expectedUsers, result);
        verify(userRepository).findAll();
    }

    @Test
    void save_ShouldSaveUser() {
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.save(user);

        assertEquals(user, result);
        verify(userRepository).save(user);
    }

    @Test
    void deleteById_ShouldDeleteUser() {
        userService.deleteById(1L);

        verify(userRepository).deleteById(1L);
    }
}
