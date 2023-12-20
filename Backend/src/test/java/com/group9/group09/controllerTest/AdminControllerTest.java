package com.group9.group09.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.group9.group09.DTO.RequestDTO.CityRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.controller.AdminController;
import com.group9.group09.service.interfaces.AdminService;
import com.group9.group09.config.JwtService;
import com.group9.group09.exception.NotAdminAccessException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private HttpServletRequest httpServletRequest;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCity_Success() {
        CityRequestDTO cityRequestDTO = new CityRequestDTO();
        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer test-token");

        // Mock jwtService's extractUsername method
        when(jwtService.extractUsername("test-token")).thenReturn("test-username");

        // Mock userRepository's findByUsermail method
        User user = new User();
        user.setUserId("1");
        user.setIsAdmin(1); // Set user as admin
        Optional<User> optionalUser = Optional.of(user);
        when(userRepository.findByUsermail("test-username")).thenReturn(optionalUser);

        // Mock adminService's addCityService method
        ResponseDTO mockResponse = new ResponseDTO();
        when(adminService.addCityService(any(CityRequestDTO.class))).thenReturn(mockResponse);

        ResponseEntity<?> responseEntity = adminController.addState(cityRequestDTO, httpServletRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

}
