package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Activity;
import com.group9.group09.model.City;
import com.group9.group09.model.Place;
import com.group9.group09.model.State;

import java.util.List;

public class CountryResponseDTO {

    private String countryName;
    private String description;
    private List<State> stateList;
    private List<City> cityList;

    private List<Place> placeList;
    private List<Activity> activityList;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
