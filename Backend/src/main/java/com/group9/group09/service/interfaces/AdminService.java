package com.group9.group09.service.interfaces;


import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;

public interface AdminService {
    ResponseDTO addCountryService(CountryRequestDTO countryRequestDTO);

    ResponseDTO addStateService(StateRequestDTO stateRequestDTO);

    ResponseDTO addCityService(CityRequestDTO cityRequestDTO);
    
    ResponseDTO addPlaceService(PlaceRequestDTO placeRequestDTO);

    ResponseDTO addActivityService(ActivityRequestDTO activityRequestDTO);      
}
