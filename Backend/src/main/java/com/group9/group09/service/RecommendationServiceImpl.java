package com.group9.group09.service;

import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.Activity;
import com.group9.group09.model.Place;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.ActivityRepository;
import com.group9.group09.repository.interfaces.PlaceRepository;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public RecommendationResponseDTO getUserRecommendationsBasedOnInterests(RequestDTO requestDTO) {

        List<String> userInterests = fetchUserInterests(requestDTO.getToken());

        RecommendationResponseDTO responseDTO = new RecommendationResponseDTO();

        ActivityResponseDTO activityResponseDTO = new ActivityResponseDTO();
        List<Activity> activityObjectsResponseList = new ArrayList<>();

        for (String interest: userInterests){
            activityObjectsResponseList.addAll(fetchActivitiesBasedOnInterest(interest));
        }
        activityResponseDTO.setActivityObjectsResponseList(activityObjectsResponseList);
        responseDTO.setActivityResponseDTO(activityResponseDTO);

        List<PlaceResponseDTO> placeResponseDTOList = new ArrayList<>();
        for (String interest: userInterests){
            placeResponseDTOList.addAll(fetchPlacesBasedOnInterest(interest));
        }
        responseDTO.setPlaceResponseDTO(placeResponseDTOList);

        return responseDTO;
    }

    @Override
    public List<String> fetchUserInterests(String token) {

        token = token.replace("Bearer ","");
        String username = jwtService.extractUsername(token);
        Optional<User> user = userRepository.findByUsermail(username);
        String interest;
        String[] interestsArray = null;
        if (user.isPresent()){
            interest = user.get().getInterest();
            interestsArray = interest.split(",");
            for (int i=0; i<interestsArray.length; i++){
                interestsArray[i] = interestsArray[i].trim();
            }
        }
        return Arrays.asList(interestsArray);
    }

    @Override
    public List<Activity> fetchActivitiesBasedOnInterest(String interest) {
        try {
            return activityRepository.getActivitiesByInterest(interest);
        }
        catch(Exception e){
            throw new RuntimeException("Error in fetching activities");
        }
    }

    @Override
    public List<PlaceResponseDTO> fetchPlacesBasedOnInterest(String interest) {
        try {
            List<PlaceResponseDTO> placeResponseDTOList = new ArrayList<>();
            List<Place> places = placeRepository.getPlacesByInterest(interest);
            for (Place place : places){
                PlaceResponseDTO placeResponseDTO = new PlaceResponseDTO();
                placeResponseDTO.setPlaceID(place.getPlaceId());
                placeResponseDTO.setInterest(place.getInterest());
                placeResponseDTO.setPlaceName(place.getPlaceName());
                placeResponseDTO.setDescription(place.getDescription());
                placeResponseDTO.setPlaceImageLink(place.getPlaceImageLink());

                placeResponseDTOList.add(placeResponseDTO);
            }
            return placeResponseDTOList;
        }
        catch(Exception e){
            throw new RuntimeException("Error in fetching places");
        }
    }
}
