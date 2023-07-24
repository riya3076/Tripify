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
}