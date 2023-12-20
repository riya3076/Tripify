package com.group9.group09.serviceTest;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.*;
import com.group9.group09.repository.interfaces.*;
import com.group9.group09.service.HomePageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HomePageServiceImplTest {

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private StateRepository stateRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private ItemsRepository itemsRepository;

    @Mock
    private WishlistRepository wishlistRepository;

    @Mock
    private ItineraryRepository itineraryRepository;

    @Mock
    private ReviewsPlaceRepository reviewsPlaceRepository;

    @Mock
    private ReviewsActivityRepository reviewsActivityRepository;

    @InjectMocks
    private HomePageServiceImpl homePageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Write test cases for all methods in HomePageServiceImpl class
    // Use Mockito to mock the behavior of the repository methods

    @Test
    void testChoiceSelectorService_InternationalRegion() {
        ChoiceRequestDTO choiceRequestDTO = new ChoiceRequestDTO();
        choiceRequestDTO.setToken("test_token");
        choiceRequestDTO.setRegion("International");

        // Mock jwtService to return the username when extracting from token
        when(jwtService.extractUsername(choiceRequestDTO.getToken())).thenReturn("test_user");

        // Mock countryRepository's getCountries method to return a list of countries
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country());
        when(countryRepository.getCountries()).thenReturn(countryList);

        ChoiceResponseDTO responseDTO = homePageService.choiceSelectorService(choiceRequestDTO);

        assertEquals("International", responseDTO.getRegion());
        assertEquals(countryList, responseDTO.getRegionList());
    }

    @Test
    void testChoiceSelectorService_DomesticRegion() {
        ChoiceRequestDTO choiceRequestDTO = new ChoiceRequestDTO();
        choiceRequestDTO.setToken("test_token");
        choiceRequestDTO.setRegion("domestic");

        // Mock jwtService to return the username when extracting from token
        when(jwtService.extractUsername(choiceRequestDTO.getToken())).thenReturn("test_user");

        // Mock userRepository's findByUsermail method to return an optional user with homeCountry set
        User testUser = new User();
        testUser.setHomeCountry(1);
        when(userRepository.findByUsermail("test_user")).thenReturn(Optional.of(testUser));

        // Mock countryRepository's findByCountryId method to return a country
        Country testCountry = new Country();
        testCountry.setCountryID(1);
        when(countryRepository.findByCountryId(1)).thenReturn(Optional.of(testCountry));

        // Mock stateRepository's getStatesbyCountryID method to return a list of states
        List<State> stateList = new ArrayList<>();
        stateList.add(new State());
        when(stateRepository.getStatesbyCountryID(1)).thenReturn(stateList);

        ChoiceResponseDTO responseDTO = homePageService.choiceSelectorService(choiceRequestDTO);

        assertEquals("domestic", responseDTO.getRegion());
        assertEquals(stateList, responseDTO.getRegionList());
    }

}
