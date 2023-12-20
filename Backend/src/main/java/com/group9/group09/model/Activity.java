package com.group9.group09.model;

import java.awt.*;

public class Activity {

    private Integer activityId;
    private String activityName;
    private String description;
    private Integer placeId;
    private Integer cityId;
    private String reviews;

    private String interest;
    private String activityImageLink;

    /**
     * Get the reviews of the activity.
     *
     * @return the reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * Set the reviews of the activity.
     *
     * @param reviews the reviews to set
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    /**
     * Get the name of the activity.
     *
     * @return the activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Set the name of the activity.
     *
     * @param activityName the activityName to set
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * Get the ID of the activity.
     *
     * @return the activityId
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * Set the ID of the activity.
     *
     * @param activityId the activityId to set
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * Get the description of the activity.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the activity.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the ID of the place associated with the activity.
     *
     * @return the placeId
     */
    public Integer getPlaceId() {
        return placeId;
    }

    /**
     * Set the ID of the place associated with the activity.
     *
     * @param placeId the placeId to set
     */
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    /**
     * Get the ID of the city associated with the activity.
     *
     * @return the cityId
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Set the ID of the city associated with the activity.
     *
     * @param cityId the cityId to set
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getActivityImageLink() {
        return activityImageLink;
    }

    public void setActivityImageLink(String activityImageLink) {
        this.activityImageLink = activityImageLink;
    }
}
