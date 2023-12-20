package com.group9.group09.serviceTest;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.ResponseDTO.ActivityResponseDTO;
import com.group9.group09.DTO.ResponseDTO.PlaceResponseDTO;
import com.group9.group09.DTO.ResponseDTO.RecommendationResponseDTO;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.Activity;
import com.group9.group09.model.Place;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.ActivityRepository;
import com.group9.group09.repository.interfaces.PlaceRepository;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.RecommendationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecommendationServiceImplTest {

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private PlaceRepository placeRepository;

    @InjectMocks
    private RecommendationServiceImpl recommendationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchActivitiesBasedOnInterest() {
        String interest = "test-interest";
        List<Activity> activityList = Arrays.asList(
                new Activity(),
                new Activity(),
                new Activity()
        );

        // Mock the activityRepository.getActivitiesByInterest method
        when(activityRepository.getActivitiesByInterest(interest)).thenReturn(activityList.subList(0, 2));

        List<Activity> result = recommendationService.fetchActivitiesBasedOnInterest(interest);
        assertEquals(2, result.size());
    }

}
