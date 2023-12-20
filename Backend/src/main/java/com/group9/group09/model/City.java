package com.group9.group09.model;

import java.util.List;

public class City {

    private String cityName;
    private Integer cityId;
    private String description;
    private Integer stateId;

    private List<Place> places;
    private String cityImageLink;

    /**
     * Get the name of the city.
     *
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set the name of the city.
     *
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Get the ID of the city.
     *
     * @return the cityId
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Set the ID of the city.
     *
     * @param cityId the cityId to set
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * Get the description of the city.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the city.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the ID of the state associated with the city.
     *
     * @return the stateId
     */
    public Integer getStateId() {
        return stateId;
    }

    /**
     * Set the ID of the state associated with the city.
     *
     * @param stateId the stateId to set
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    /**
     * Get the list of places in the city.
     *
     * @return the places
     */
    public List<Place> getPlaces() {
        return places;
    }

    /**
     * Set the list of places in the city.
     *
     * @param places the places to set
     */
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public String getCityImageLink() {
        return cityImageLink;
    }

    public void setCityImageLink(String cityImageLink) {
        this.cityImageLink = cityImageLink;
    }
}
