package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.config.JwtService;
import com.group9.group09.exception.NotAdminAccessException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * Controller class to handle admin-related operations.
 */
@RestController
@RequestMapping(path="/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactoryImpl.getLogger();


    /**
     * Endpoint to add a new country.
     *
     * @param countryRequestDTO The CountryRequestDTO containing country details.
     * @param request           The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/addCountry")
    public ResponseEntity<?> addCountry(@RequestBody CountryRequestDTO countryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:");
            countryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(countryRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsAdmin()==1){

          //  countryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ResponseDTO responseDTO = adminService.addCountryService(countryRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: Add country admin api failed ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            //response.setMessage("Add country admin api failed");
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to add a new state.
     *
     * @param stateRequestDTO The StateRequestDTO containing state details.
     * @param request         The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */

    @PostMapping(path = "/addState")
    public ResponseEntity<?> addState(@RequestBody StateRequestDTO stateRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:");
            stateRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(stateRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsAdmin()==1){

            ResponseDTO responseDTO = adminService.addStateService(stateRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
            else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add state admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to add a new city.
     *
     * @param cityRequestDTO The CityRequestDTO containing city details.
     * @param request        The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/addCity")
    public ResponseEntity<?> addState(@RequestBody CityRequestDTO cityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addCity method running'");

            logger.info("Info Message:");
            cityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(cityRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsAdmin()==1){

            ResponseDTO responseDTO = adminService.addCityService(cityRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add city admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to add a new place.
     *
     * @param placeRequestDTO The PlaceRequestDTO containing place details.
     * @param request         The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/addPlace")
    public ResponseEntity<?> addPlace(@RequestBody PlaceRequestDTO placeRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addPlace method running in controller'");
            logger.info("Info Message:");

            placeRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(placeRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsAdmin()==1){
            ResponseDTO responseDTO = adminService.addPlaceService(placeRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add palce admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }

    }

    /**
     * Endpoint to add a new activity.
     *
     * @param activityRequestDTO The ActivityRequestDTO containing activity details.
     * @param request            The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/addActivity")
    public ResponseEntity<?> addActivity(@RequestBody ActivityRequestDTO activityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addactivity method running in controller'");
            logger.info("Info Message:");
            activityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(activityRequestDTO.getToken());

            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsAdmin()==1){
            ResponseDTO responseDTO = adminService.addActivityService(activityRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add activity admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}

