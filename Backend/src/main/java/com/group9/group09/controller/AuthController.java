package com.group9.group09.controller;

import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.RequestDTO.OTPRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.RequestDTO.UserEditRequestDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.service.interfaces.OTPService;
import com.group9.group09.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class to handle user-related operations.
 */
@RestController
@RequestMapping(path = "/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private static String userName;
    @Autowired
    private OTPService otpService;
    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Handles the user login request.
     *
     * @param user the User object containing login credentials
     * @return the ResponseEntity containing the ResponseDTO object
     */
    @PostMapping(path = "/login")
    public ResponseEntity<?> userLogin(@RequestBody User user) {
        try {
            logger.info("Info Message: ");
            ResponseDTO serviceResponse = userService.loginUserService(user);
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }catch (UserNotFoundException e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage()+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Login Issue"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the user registration request.
     *
     * @param user the User object containing registration details
     * @return the ResponseEntity containing the ResponseDTO object
     */
    @PostMapping(path = "/register")
    public ResponseEntity<?> userRegister(@RequestBody User user) {

        try {
            logger.info("Info Message: ");
            ResponseDTO serviceResponse = userService.registerUserService(user);
            if (serviceResponse.getSuccess().equalsIgnoreCase("User already present")){
                throw new UserNotFoundException(serviceResponse.getSuccess());
            }
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage()+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Registration Issue"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the user information edit request.
     *
     * @param userEditRequestDTO the UserEditRequestDTO object containing user edit details
     * @return the ResponseEntity containing the ResponseDTO object
     */
    @PostMapping(path = "/edit")
    public ResponseEntity<?> userInfoEdit(@RequestBody UserEditRequestDTO userEditRequestDTO) {

        try {
            if (userEditRequestDTO.getEmail() == null)
                userEditRequestDTO.setEmail(getUserName());

            User user = userService.getUserbyEmail(userEditRequestDTO);
            userEditRequestDTO.setUser(user);
            ResponseDTO updatedUserResponse = userService.updateUserpasswordService(userEditRequestDTO);

            setUserName(null);
            return new ResponseEntity<>(updatedUserResponse, HttpStatus.OK);
        }catch (UserNotFoundException e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage()+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage("User edit api failed "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the user forgot password request.
     *
     * @param user the User object containing user email
     * @return the ResponseEntity containing the ResponseDTO object
     */
    @PostMapping(path = "/forgotpassword")
    public ResponseEntity<?> forgotPasswordForUser(@RequestBody User user) {
        try {
            UserEditRequestDTO userEditRequestDTO = new UserEditRequestDTO();
            userEditRequestDTO.setEmail(user.getEmail());
            User userFromDb = userService.getUserbyEmail(userEditRequestDTO);

            boolean status = false;
            if (userFromDb != null) {
                status = otpService.generateOTP(userFromDb.getEmail());
                setUserName(userFromDb.getUsername());
            }
            ResponseDTO responseDTO = new ResponseDTO();
            if (status) {
                responseDTO.setMessage("OTP Generated");
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            } else {
                responseDTO.setMessage("Issue in creating OTP");
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseDTO);
            }
        } catch (UserNotFoundException e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage("User Not Found"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Something went wrong"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(response);
        }
    }

    /**
     * Handles the user OTP verification request.
     *
     * @param otpRequest the OTPRequestDTO object containing the OTP
     * @return the ResponseEntity containing the ResponseDTO object
     */
    @PostMapping(path = "/otp")
    public ResponseEntity<?> verifyUser(@RequestBody OTPRequestDTO otpRequest) {
        try {
            boolean status = otpService.verifyUserUsingOTP(otpRequest);

            ResponseDTO responseDTO = new ResponseDTO();
            if (status) {
                responseDTO.setMessage("success");
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            } else {
                responseDTO.setMessage("Incorrect OTP");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
            }
        }catch (UserNotFoundException e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage()+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Something went wrong"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(response);
        }
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        AuthController.userName = userName;
    }
}