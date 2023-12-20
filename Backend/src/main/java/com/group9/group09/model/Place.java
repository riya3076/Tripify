package com.group9.group09.model;

import java.util.List;

public class Place {

    private String placeName;
    private Integer placeId;
    private String description;
    private Integer cityId;
    private String cityName;
    private String interest;
    private String placeImageLink;

    private List<String> activitiesStringList;

    /**
     * Get the list of activity names associated with the place.
     *
     * @return the activitiesStringList
     */
    public List<String> getActivitiesStringList() {
        return activitiesStringList;
    }

    /**
     * Set the list of activity names associated with the place.
     *
     * @param activitiesStringList the activitiesStringList to set
     */
    public void setActivitiesStringList(List<String> activitiesStringList) {
        this.activitiesStringList = activitiesStringList;
    }

    private List<Activity> activities;

    /**
     * Get the name of the place.
     *
     * @return the placeName
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * Set the name of the place.
     *
     * @param placeName the placeName to set
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
     * Get the ID of the place.
     *
     * @return the placeId
     */
    public Integer getPlaceId() {
        return placeId;
    }

    /**
     * Set the ID of the place.
     *
     * @param placeId the placeId to set
     */
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    /**
     * Get the description of the place.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the place.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the ID of the city associated with the place.
     *
     * @return the cityId
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Set the ID of the city associated with the place.
     *
     * @param cityId the cityId to set
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * Get the list of activities associated with the place.
     *
     * @return the activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * Set the list of activities associated with the place.
     *
     * @param activities the activities to set
     */
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPlaceImageLink() {
        return placeImageLink;
    }

    public void setPlaceImageLink(String placeImageLink) {
        this.placeImageLink = placeImageLink;
    }
}
