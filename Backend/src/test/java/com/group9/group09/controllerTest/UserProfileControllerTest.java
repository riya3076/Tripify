package com.group9.group09.controllerTest;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.RequestDTO.UserProfileRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.ResponseDTO.UserProfileResponseDTO;
import com.group9.group09.controller.UserProfileController;
import com.group9.group09.service.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private UserProfileController userProfileController;

    @Test
    public void testGetUserDetails() {
        UserProfileResponseDTO mockResponseDTO = new UserProfileResponseDTO();
        when(request.getHeader("Authorization")).thenReturn("Bearer fakeToken");
        when(userService.getUserDetails(any(RequestDTO.class))).thenReturn(mockResponseDTO);

        RequestDTO requestDTO = new RequestDTO();
        ResponseEntity<?> responseEntity = userProfileController.getUserDetails(requestDTO, request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponseDTO, responseEntity.getBody());
    }

    @Test
    public void testGetUserDetailsException() {
        when(request.getHeader("Authorization")).thenReturn("Bearer fakeToken");
        when(userService.getUserDetails(any(RequestDTO.class))).thenThrow(new RuntimeException("Mocked exception"));

        RequestDTO requestDTO = new RequestDTO();
        ResponseEntity<?> responseEntity = userProfileController.getUserDetails(requestDTO, request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        String expectedErrorMessage = "Something went wrongMocked exception";
        ErrorResponse actualErrorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals(expectedErrorMessage, actualErrorResponse.getMessage());
    }

    @Test
    public void testSetUserDetails() {
        ResponseDTO mockResponseDTO = new ResponseDTO();
        when(request.getHeader("Authorization")).thenReturn("Bearer fakeToken");
        when(userService.setUserDetails(any(UserProfileRequestDTO.class))).thenReturn(mockResponseDTO);

        UserProfileRequestDTO requestDTO = new UserProfileRequestDTO();
        ResponseEntity<?> responseEntity = userProfileController.setUserDetails(requestDTO, request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponseDTO, responseEntity.getBody());
    }

    @Test
    public void testSetUserDetailsException() {
        when(request.getHeader("Authorization")).thenReturn("Bearer fakeToken");
        when(userService.setUserDetails(any(UserProfileRequestDTO.class))).thenThrow(new RuntimeException("Mocked exception"));

        UserProfileRequestDTO requestDTO = new UserProfileRequestDTO();
        ResponseEntity<?> responseEntity = userProfileController.setUserDetails(requestDTO, request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        String expectedErrorMessage = "Something went wrongMocked exception"; // Update this line to match the exception's message
        ErrorResponse actualErrorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals(expectedErrorMessage, actualErrorResponse.getMessage());
    }

}