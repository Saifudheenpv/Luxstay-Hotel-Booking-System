package com.hotel.controller;

import com.hotel.dto.UserRegistrationDTO;
import com.hotel.model.User;
import com.hotel.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    @Mock
    private HttpSession session;

    @InjectMocks
    private AuthController authController;

    private UserRegistrationDTO userRegistrationDTO;
    private User user;

    @BeforeEach
    void setUp() {
        userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setUsername("testuser");
        userRegistrationDTO.setEmail("test@example.com");
        userRegistrationDTO.setPassword("password123");
        userRegistrationDTO.setFirstName("John");
        userRegistrationDTO.setLastName("Doe");
        userRegistrationDTO.setPhone("1234567890");
        userRegistrationDTO.setAddress("Test Address");

        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
    }

    @Test
    void showRegistrationForm_ShouldReturnRegisterView() {
        String viewName = authController.showRegistrationForm(model);
        assertEquals("register", viewName);
        verify(model).addAttribute(anyString(), any(UserRegistrationDTO.class));
    }

    @Test
    void registerUser_WithMatchingPasswords_ShouldRegisterSuccessfully() {
        when(userService.registerUser(any(User.class))).thenReturn(user);

        String result = authController.registerUser(userRegistrationDTO, "password123", redirectAttributes);

        assertEquals("redirect:/auth/login", result);
        verify(redirectAttributes).addFlashAttribute("success", "Registration successful! Please login.");
    }

    @Test
    void registerUser_WithNonMatchingPasswords_ShouldReturnError() {
        String result = authController.registerUser(userRegistrationDTO, "differentpassword", redirectAttributes);

        assertEquals("redirect:/auth/register", result);
        verify(redirectAttributes).addFlashAttribute("error", "Passwords do not match");
        verify(userService, never()).registerUser(any(User.class));
    }

    @Test
    void registerUser_WithExistingUsername_ShouldReturnError() {
        when(userService.registerUser(any(User.class))).thenThrow(new RuntimeException("Username already exists"));

        String result = authController.registerUser(userRegistrationDTO, "password123", redirectAttributes);

        assertEquals("redirect:/auth/register", result);
        verify(redirectAttributes).addFlashAttribute("error", "Username already exists");
    }

    @Test
    void showLoginForm_ShouldReturnLoginView() {
        String viewName = authController.showLoginForm();
        assertEquals("login", viewName);
    }

    @Test
    void loginUser_WithValidCredentials_ShouldLoginSuccessfully() {
        when(userService.authenticate("testuser", "password123")).thenReturn(Optional.of(user));

        String result = authController.loginUser("testuser", "password123", session, redirectAttributes);

        assertEquals("redirect:/", result);
        verify(session).setAttribute("userId", 1L);
        verify(session).setAttribute("username", "testuser");
        verify(session).setAttribute("userFirstName", "John");
        verify(redirectAttributes).addFlashAttribute("success", "Welcome back, John!");
    }

    @Test
    void loginUser_WithInvalidCredentials_ShouldReturnError() {
        when(userService.authenticate("testuser", "wrongpassword")).thenReturn(Optional.empty());

        String result = authController.loginUser("testuser", "wrongpassword", session, redirectAttributes);

        assertEquals("redirect:/auth/login", result);
        verify(redirectAttributes).addFlashAttribute("error", "Invalid username or password");
        verify(session, never()).setAttribute(anyString(), any());
    }

    @Test
    void logout_ShouldInvalidateSession() {
        String result = authController.logout(session, redirectAttributes);

        assertEquals("redirect:/", result);
        verify(session).invalidate();
        verify(redirectAttributes).addFlashAttribute("success", "You have been logged out successfully");
    }
}
