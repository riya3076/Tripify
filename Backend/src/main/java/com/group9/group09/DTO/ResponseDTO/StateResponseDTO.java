package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Activity;
import com.group9.group09.model.City;
import com.group9.group09.model.Place;

import java.util.List;

public class StateResponseDTO {

    private Integer stateID;
    private String stateName;
    private String description;

    private List<City> cityList;

    private List<Place> placeList;
    private List<Activity> activityList;

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
