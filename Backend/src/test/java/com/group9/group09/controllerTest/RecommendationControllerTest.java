package com.group9.group09.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.ResponseDTO.RecommendationResponseDTO;
import com.group9.group09.controller.RecommendationController;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.service.interfaces.RecommendationService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecommendationControllerTest {

    @Mock
    private RecommendationService recommendationService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @InjectMocks
    private RecommendationController recommendationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRecommendations_Success() {
        RequestDTO requestDTO = new RequestDTO();
        when(httpServletRequest.getHeader("Authorization")).thenReturn("test-token");

        // Mock recommendationService's getUserRecommendationsBasedOnInterests method
        RecommendationResponseDTO mockResponse = new RecommendationResponseDTO();
        when(recommendationService.getUserRecommendationsBasedOnInterests(any(RequestDTO.class))).thenReturn(mockResponse);

        ResponseEntity<?> responseEntity = recommendationController.getRecommendations(requestDTO, httpServletRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

    @Test
    void testGetRecommendations_Exception() {
        RequestDTO requestDTO = new RequestDTO();
        when(httpServletRequest.getHeader("Authorization")).thenReturn("test-token");

        // Mock recommendationService's getUserRecommendationsBasedOnInterests method to throw an exception
        when(recommendationService.getUserRecommendationsBasedOnInterests(any(RequestDTO.class))).thenThrow(new RuntimeException());

        ResponseEntity<?> responseEntity = recommendationController.getRecommendations(requestDTO, httpServletRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        // Add assertions for the response body as needed.
    }

}
