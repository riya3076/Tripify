package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Activity;
import com.group9.group09.model.City;
import com.group9.group09.model.Place;

import java.util.List;

/**
 * Data Transfer Object for City Response.
 */
public class CityResponseDTO {

    private Integer cityID;
    private String cityName;
    private String description;
    private List<Place> placeObjectResponseList;
    private List<Activity> activityList;

    /**
     * Get the list of Place objects from the response.
     *
     * @return the list of Place objects
     */
    public List<Place> getPlaceObjectResponseList() {
        return placeObjectResponseList;
    }

    /**
     * Set the list of Place objects in the response.
     *
     * @param placeObjectResponseList the list of Place objects to set
     */
    public void setPlaceObjectResponseList(List<Place> placeObjectResponseList) {
        this.placeObjectResponseList = placeObjectResponseList;
    }

    /**
     * Get the city ID from the response.
     *
     * @return the city ID
     */
    public Integer getCityID() {
        return cityID;
    }

    /**
     * Set the city ID in the response.
     *
     * @param cityID the city ID to set
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     * Get the city name from the response.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set the city name in the response.
     *
     * @param cityName the city name to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Get the description from the response.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description in the response.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the list of place names from the response.
     *
     * @return the list of place names
     */


    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
