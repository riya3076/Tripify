package com.group9.group09.controllerTest;

import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.RequestDTO.UserEditRequestDTO;
import com.group9.group09.controller.AuthController;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.service.interfaces.OTPService;
import com.group9.group09.service.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @Mock
    private OTPService otpService;

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserLogin_Success() {
        User user = new User();
        user.setUserId("1");
        user.setPassword("testPassword");

        // Mock userService's loginUserService method
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess("Login successful");
        when(userService.loginUserService(user)).thenReturn(responseDTO);

        ResponseEntity<?> responseEntity = authController.userLogin(user);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseDTO, responseEntity.getBody());


        verify(userService, times(1)).loginUserService(user);
    }

    @Test
    void testUserLogin_Failure() {
        User user = new User();
        user.setUserId("1");
        user.setPassword("testPassword");


        when(userService.loginUserService(user)).thenThrow(new RuntimeException());

        ResponseEntity<?> responseEntity = authController.userLogin(user);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ErrorResponse);


        verify(userService, times(1)).loginUserService(user);
    }

    @Test
    void testUserRegister_Success() {
        User user = new User();
        user.setUserId("1");
        user.setPassword("testPassword");


        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess("Registration successful");
        when(userService.registerUserService(user)).thenReturn(responseDTO);

        ResponseEntity<?> responseEntity = authController.userRegister(user);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseDTO, responseEntity.getBody());


        verify(userService, times(1)).registerUserService(user);
    }

    @Test
    void testUserRegister_UserNotFoundException() {
        User user = new User();
        user.setUserId("1");
        user.setPassword("testPassword");

        // Mock userService's registerUserService method to return a specific response
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccess("User already present");
        when(userService.registerUserService(user)).thenReturn(responseDTO);

        ResponseEntity<?> responseEntity = authController.userRegister(user);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals("User already presentUser already present", errorResponse.getMessage());

        
        verify(userService, times(1)).registerUserService(user);
    }


}