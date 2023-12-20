package com.group9.group09.service;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.model.*;
import com.group9.group09.repository.interfaces.*;
import com.group9.group09.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @Override
    public ResponseDTO addCountryService(CountryRequestDTO countryRequestDTO) {

        ResponseDTO countryResponseDTO = new ResponseDTO();
        if (countryRequestDTO.getCountry_name() == null) {
            throw new RuntimeException();
        }

        Optional<Country> country;
        try {
            country = countryRepository.findByCountryName(countryRequestDTO.getCountry_name());
            countryResponseDTO.setMessage("Country already present");
            return countryResponseDTO;

        } catch (RuntimeException e) {
            countryRepository.addCountry(countryRequestDTO.getCountry_name(), countryRequestDTO.getDescription());
            countryResponseDTO.setMessage("Country Added Succesfully");
            return countryResponseDTO;
        }
    }

    @Override
    public ResponseDTO addStateService(StateRequestDTO stateRequestDTO) {
        ResponseDTO stateResponseDTO = new ResponseDTO();
        if (stateRequestDTO.getStateName() == null || stateRequestDTO.getCountry_name() == null) {
            throw new RuntimeException("state name or country name not provided it is mandatory");
        }

        Optional<State> state;
        Optional<Country> country;
        try {
            country = countryRepository.findByCountryName(stateRequestDTO.getCountry_name());
            if (country.isPresent()) {
                try {
                    state = stateRepository.isStatePresent(stateRequestDTO.getStateName(), country.get().getCountryID());
                } catch (Exception e) {
                    stateRepository.addState(stateRequestDTO.getStateName(), stateRequestDTO.getDescription(), country.get().getCountryID());
                }
            } else {
                throw new RuntimeException();
            }
            stateResponseDTO.setMessage("State added Successfully ");
            return stateResponseDTO;
        } catch (RuntimeException e) {
            stateResponseDTO.setMessage("Error adding state");
            return stateResponseDTO;
        }
    }

    @Override
    public ResponseDTO addCityService(CityRequestDTO cityRequestDTO) {
        ResponseDTO cityResponseDTO = new ResponseDTO();
        if (cityRequestDTO.getCity() == null || cityRequestDTO.getStateName() ==null) {
            throw new RuntimeException("City name or state name not provided it is mandatory");
        }
        Optional<City> city;
        Optional<State> state;
        try {
            state = stateRepository.findByStateName(cityRequestDTO.getStateName());
            if(state.isPresent()){
                try{
                    city = cityRepository.isCityPresent(cityRequestDTO.getCity(),state.get().getStateID());
                }catch (Exception e){
                    cityRepository.addCity(cityRequestDTO.getCity(), cityRequestDTO.getDescription(), state.get().getStateID(),cityRequestDTO.getWeather());
                }
            }
            else {
                throw new RuntimeException();
            }
            cityResponseDTO.setMessage("City added Successfully ");
            return cityResponseDTO;
        } catch (RuntimeException e) {
            cityResponseDTO.setMessage("Error adding City");
            return cityResponseDTO;
        }
    }

    @Override
    public ResponseDTO addPlaceService(PlaceRequestDTO placeRequestDTO) {
        ResponseDTO placeResponseDTO = new ResponseDTO();
        if (placeRequestDTO.getPlaceName() == null || placeRequestDTO.getCityName() ==null) {
            throw new RuntimeException("Place name or City name not provided, it is mandatory");
        }
        Optional<City> city;
        Optional<Place> place;
        try {
            city = cityRepository.findByCityName(placeRequestDTO.getCityName());
            if(city.isPresent()){
                try{
                    place = placeRepository.isPlacePresent(placeRequestDTO.getPlaceName(),placeRequestDTO.getCityId());
                }catch (Exception e){
                    placeRepository.addPlace(placeRequestDTO.getPlaceName(),placeRequestDTO.getDescription(), city.get().getCityId(),placeRequestDTO.getInterest());
                }
            }
            else {
                throw new RuntimeException();
            }
            placeResponseDTO.setMessage("Place added Successfully ");
            return placeResponseDTO;

        } catch (RuntimeException e) {
            placeResponseDTO.setMessage("Error adding Place");
            return placeResponseDTO;
        }
    }

    @Override
    public ResponseDTO addActivityService(ActivityRequestDTO activityRequestDTO) {
        ResponseDTO placeResponseDTO = new ResponseDTO();
        if (activityRequestDTO.getActivityName() == null || activityRequestDTO.getCity_name() ==null) {
            throw new RuntimeException("Activity name or City id not provided, it is mandatory");
        }
        Optional<City> city;
        Optional<Activity> activity;
        try {
            city = cityRepository.findByCityName(activityRequestDTO.getCity_name());
            if(city.isPresent()){
                try{
                    activity = activityRepository.isActivityPresent(activityRequestDTO.getActivityName(),city.get().getCityId());
                }catch (Exception e){
                    activityRepository.addPlace(activityRequestDTO.getActivityName(),activityRequestDTO.getDescription(), city.get().getCityId(),activityRequestDTO.getInterest());
                }
            }
            else {
                throw new RuntimeException();
            }
            placeResponseDTO.setMessage("Activity added Successfully ");
            return placeResponseDTO;
            
        } catch (RuntimeException e) {
            placeResponseDTO.setMessage("Error adding activity");
            return placeResponseDTO;
        }
    }
}