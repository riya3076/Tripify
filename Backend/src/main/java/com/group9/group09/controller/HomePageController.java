package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.HomePageService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/home")
@CrossOrigin(origins = "http://localhost:3000")
public class HomePageController {

    @Autowired
    private HomePageService homeService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactoryImpl.getLogger();
    /**
     * Handles the choice selection request.
     *
     * @param choice  the ChoiceRequestDTO object
     * @param request the HttpServletRequest object
     * @return the ResponseEntity containing the ChoiceResponseDTO object
     */
    @PostMapping(path = "/choice")
    public ResponseEntity<?> choiceSelector(@RequestBody ChoiceRequestDTO choice, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            choice.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ChoiceResponseDTO choiceResponseDTO = homeService.choiceSelectorService(choice);
            return new ResponseEntity<>(choiceResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Choice selector api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to get country details based on the provided CountryRequestDTO.
     *
     * @param countryRequestDTO The CountryRequestDTO containing country selection details.
     * @param request           The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/country")
    public ResponseEntity<?> getCountry(@RequestBody CountryRequestDTO countryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            countryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            CountryResponseDTO countryResponseDTO = homeService.countrySelectorService(countryRequestDTO);
            return new ResponseEntity<>(countryResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");

            ErrorResponse response = new ErrorResponse();
            response.setMessage("Choice selector api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the location selection request.
     *
     * @param location the LocationRequestDTO object
     * @param request  the HttpServletRequest object
     * @return the ResponseEntity containing the LocationResponseDTO object
     */
    @PostMapping(path = "/location")
    public ResponseEntity<?> locationSelector(@RequestBody LocationRequestDTO location, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            location.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            LocationResponseDTO locationResponseDTO = homeService.locationSelectorService(location);
            return new ResponseEntity<>(locationResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("location selector api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the city selection request.
     *
     * @param city    the CityRequestDTO object
     * @param request the HttpServletRequest object
     * @return the ResponseEntity containing the CityResponseDTO object
     */
    @PostMapping(path = "/city")
    public ResponseEntity<?> citySelector(@RequestBody CityRequestDTO city, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            city.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            CityResponseDTO cityResponseDTO = homeService.citySelectorService(city);
            return new ResponseEntity<>(cityResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("city selector api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the place selection request.
     *
     * @param placeRequestDTO the PlaceRequestDTO object
     * @param request         the HttpServletRequest object
     * @return the ResponseEntity containing the PlaceResponseDTO object
     */
    @PostMapping(path = "/place")
    public ResponseEntity<?> placeSelector(@RequestBody PlaceRequestDTO placeRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            placeRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            PlaceResponseDTO placeResponseDTO = homeService.placeSelectorService(placeRequestDTO);
            return new ResponseEntity<>(placeResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("place selector api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the activities request.
     *
     * @param activityRequestDTO the ActivityRequestDTO object
     * @param request            the HttpServletRequest object
     * @return the ResponseEntity containing the ActivityResponseDTO object
     */
    @PostMapping(path = "/activities")
    public ResponseEntity<?> getActivities(@RequestBody ActivityRequestDTO activityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            activityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ActivityResponseDTO activityResponseDTO = homeService.getActivitiesService(activityRequestDTO);
            return new ResponseEntity<>(activityResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("activity response selector api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the wishlist request.
     *
     * @param requestDTO the WishListRequestDTO object
     * @param request            the HttpServletRequest object
     * @return the ResponseEntity containing the WishListResponseDTO object
     */
    @PostMapping(path = "/wishlist")
    public ResponseEntity<?> getWishList(@RequestBody RequestDTO requestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            requestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            WishListResponseDTO wishListResponseDTO = homeService.getWishListService(requestDTO);
            return new ResponseEntity<>(wishListResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("wishlist api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to add a new item to the wishlist.
     *
     * @param wishListRequestDTO The WishListRequestDTO containing wishlist details.
     * @param request            The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */

    @PostMapping(path = "/addwishlist")
    public ResponseEntity<?> addWishList(@RequestBody WishListRequestDTO wishListRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: in addwishlist api call");
            wishListRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(wishListRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);
            wishListRequestDTO.setUserid(Integer.parseInt(user.get().getUserId()));
            WishListResponseDTO wishListResponseDTO = homeService.addWishListService(wishListRequestDTO);
            return new ResponseEntity<>(wishListResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");

            ErrorResponse response = new ErrorResponse();
            response.setMessage("add wishlist api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to delete an item from the wishlist.
     *
     * @param wishListRequestDTO The WishListRequestDTO containing wishlist details.
     * @param request            The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */

    @PostMapping(path = "/deletewishlist")
    public ResponseEntity<?> deleteWishList(@RequestBody WishListRequestDTO wishListRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: in addwishlist api call");
            wishListRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(wishListRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);
            wishListRequestDTO.setUserid(Integer.parseInt(user.get().getUserId()));
            WishListResponseDTO wishListResponseDTO = homeService.deleteWishListService(wishListRequestDTO);
            return new ResponseEntity<>(wishListResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("delete wishlist api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }


    /**
     * Handles the itinerary request.
     *
     * @param  requestDTO ItineraryRequestDTO object
     * @param request             the HttpServletRequest object
     * @return the ResponseEntity containing the ItineraryResponseDTO object
     */
    @PostMapping(path = "/itinerary")
    public ResponseEntity<?> getItinerary(@RequestBody RequestDTO requestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            requestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ItineraryResponseDTO itineraryResponseDTO = homeService.getItinerary(requestDTO);
            return new ResponseEntity<>(itineraryResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("itinerary api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }


    /**
     * Endpoint to add a new item to the itinerary.
     *
     * @param itineraryRequestDTO The ItineraryRequestDTO containing itinerary details.
     * @param request             The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/addtoitinerary")
    public ResponseEntity<?> addtoItinerary(@RequestBody ItineraryRequestDTO itineraryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: addtoitinerary api call ");
            itineraryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));

            String username = jwtService.extractUsername(itineraryRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);
            itineraryRequestDTO.setUserid(Integer.parseInt(user.get().getUserId()));

            ItineraryResponseDTO itineraryResponseDTO = homeService.addtoItinerary(itineraryRequestDTO);
            return new ResponseEntity<>(itineraryResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("add to itinerary api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to delete an item from the itinerary.
     *
     * @param itineraryRequestDTO The ItineraryRequestDTO containing itinerary details.
     * @param request             The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/deleteitinerary")
    public ResponseEntity<?> deleteWishList(@RequestBody ItineraryRequestDTO itineraryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: in addwishlist api call");
            itineraryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(itineraryRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);
            itineraryRequestDTO.setUserid(Integer.parseInt(user.get().getUserId()));
            ItineraryResponseDTO itineraryResponseDTO = homeService.deleteItineraryService(itineraryRequestDTO);
            return new ResponseEntity<>(itineraryResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("delete itinerary api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }


    /**
     * Endpoint to get reviews for a place.
     *
     * @param reviewsPlaceRequestDTO The ReviewsPlaceRequestDTO containing place review details.
     * @param request                The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/reviewplace")
    public ResponseEntity<?> getReviewPlace(@RequestBody ReviewsPlaceRequestDTO reviewsPlaceRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            reviewsPlaceRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ReviewsPlaceResponseDTO reviewsPlaceResponseDTO  = homeService.getReviewDetails(reviewsPlaceRequestDTO);
            return new ResponseEntity<>(reviewsPlaceResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("review place api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Endpoint to add a review for a place.
     *
     * @param reviewsPlaceRequestDTO The ReviewsPlaceRequestDTO containing place review details.
     * @param request                The HttpServletRequest containing the JWT token.
     * @return A ResponseEntity containing the response message.
     */
    @PostMapping(path = "/addreviewplace")
    public ResponseEntity<?> addReviewPlace(@RequestBody ReviewsPlaceRequestDTO reviewsPlaceRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: in homepage controller addreviewplace ");
            reviewsPlaceRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            String username = jwtService.extractUsername(reviewsPlaceRequestDTO.getToken());
            Optional<User> user = userRepository.findByUsermail(username);
            reviewsPlaceRequestDTO.setUserid(Integer.parseInt(user.get().getUserId()));

            ReviewsPlaceResponseDTO reviewsPlaceResponseDTO  = homeService.addReviewplaceDetails(reviewsPlaceRequestDTO);
            return new ResponseEntity<>(reviewsPlaceResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("add review place api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }



    @PostMapping(path = "/reviewactivity")
    public ResponseEntity<?> getReviewActiviyy(@RequestBody ReviewsActivityRequestDTO reviewsActivityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            reviewsActivityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ReviewsActivityResponseDTO reviewsActivityResponseDTO = homeService.getReviewActivityDetails(reviewsActivityRequestDTO);
            return new ResponseEntity<>(reviewsActivityResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("review activity api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }


    @PostMapping(path = "/itemstocarry")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getItemstoCarry(@RequestBody ItemstoCarryRequestDTO itemstoCarryRequestDTO, HttpServletRequest request) {
        try {
            itemstoCarryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ItemsToCarryResponseDTO itemsToCarryResponseDTO =  homeService.getItemstoCarry();
            return new ResponseEntity<>(itemsToCarryResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Items to carry  api failed"+ e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    public HomePageService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomePageService homeService) {
        this.homeService = homeService;
    }
}
