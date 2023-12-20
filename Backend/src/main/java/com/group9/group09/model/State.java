package com.group9.group09.model;

import java.util.LinkedList;
import java.util.List;

public class State {
    private Integer stateID;
    private String stateName;
    private String description;
    private Integer countryID;
    private List<City> cityList;
    private String stateImageLink;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    /**
     * Get the ID of the state.
     *
     * @return the stateID
     */
    public Integer getStateID() {
        return stateID;
    }

    /**
     * Set the ID of the state.
     *
     * @param stateID the stateID to set
     */
    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    /**
     * Get the name of the state.
     *
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Set the name of the state.
     *
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Get the description of the state.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the state.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the ID of the country associated with the state.
     *
     * @return the countryID
     */
    public Integer getCountryID() {
        return countryID;
    }

    /**
     * Set the ID of the country associated with the state.
     *
     * @param countryID the countryID to set
     */
    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getStateImageLink() {
        return stateImageLink;
    }

    public void setStateImageLink(String stateImageLink) {
        this.stateImageLink = stateImageLink;
    }
}
