package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.RequestDTO.UserProfileRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.RecommendationResponseDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.ResponseDTO.UserProfileResponseDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.service.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserProfileController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Endpoint to get user details based on the provided RequestDTO.
     *
     * @param requestDTO The RequestDTO containing user details.
     * @param request    The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the UserProfileResponseDTO with user details.
     */
    @PostMapping(path = "/getProfile")
    public ResponseEntity<?> getUserDetails(@RequestBody RequestDTO requestDTO, HttpServletRequest request) {

        try {
            requestDTO.setToken(request.getHeader("Authorization"));
            UserProfileResponseDTO responseDTO =
                    userService.getUserDetails(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (UserNotFoundException e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage()+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Something went wrong"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to set user details based on the provided UserProfileRequestDTO.
     *
     * @param requestDTO The UserProfileRequestDTO containing user details.
     * @param request    The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the ResponseDTO with the result of the operation.
     */
    @PostMapping(path = "/setProfile")
    public ResponseEntity<?> setUserDetails(@RequestBody UserProfileRequestDTO requestDTO, HttpServletRequest request) {

        try {
            requestDTO.setToken(request.getHeader("Authorization"));
            ResponseDTO responseDTO =
                    userService.setUserDetails(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }catch (UserNotFoundException e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage()+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Something went wrong"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
