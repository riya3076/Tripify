package com.group9.group09.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.group9.group09.DTO.RequestDTO.ChoiceRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ChoiceResponseDTO;
import com.group9.group09.controller.HomePageController;
import com.group9.group09.service.interfaces.HomePageService;
import com.group9.group09.config.JwtService;
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

class HomePageControllerTest {

    @Mock
    private HomePageService homePageService;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private HttpServletRequest httpServletRequest;

    @InjectMocks
    private HomePageController homePageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testChoiceSelector_Success() {
        ChoiceRequestDTO choiceRequestDTO = new ChoiceRequestDTO();
        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer test-token");

        // Mock jwtService's extractUsername method
        when(jwtService.extractUsername("test-token")).thenReturn("test-username");

        // Mock userRepository's findByUsermail method
        User user = new User();
        user.setUserId("1");
        Optional<User> optionalUser = Optional.of(user);
        when(userRepository.findByUsermail("test-username")).thenReturn(optionalUser);

        // Mock homePageService's choiceSelectorService method
        ChoiceResponseDTO mockResponse = new ChoiceResponseDTO();
        when(homePageService.choiceSelectorService(any(ChoiceRequestDTO.class))).thenReturn(mockResponse);

        ResponseEntity<?> responseEntity = homePageController.choiceSelector(choiceRequestDTO, httpServletRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

    @Test
    void testChoiceSelector_Exception() {
        ChoiceRequestDTO choiceRequestDTO = new ChoiceRequestDTO();
        when(httpServletRequest.getHeader("Authorization")).thenReturn("Bearer test-token");

        // Mock jwtService's extractUsername method
        when(jwtService.extractUsername("test-token")).thenReturn("test-username");

        // Mock userRepository's findByUsermail method
        User user = new User();
        user.setUserId("1");
        Optional<User> optionalUser = Optional.of(user);
        when(userRepository.findByUsermail("test-username")).thenReturn(optionalUser);

        // Mock homePageService's choiceSelectorService method to throw an exception
        when(homePageService.choiceSelectorService(any(ChoiceRequestDTO.class))).thenThrow(new RuntimeException());

        ResponseEntity<?> responseEntity = homePageController.choiceSelector(choiceRequestDTO, httpServletRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        // Add assertions for the response body as needed.
    }

}
