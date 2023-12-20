package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object for Activity request.
 */
public class ActivityRequestDTO extends RequestDTO {

    private Integer activityID;
    private String activityName;
    private String description;
    private Integer city_id;
    private String city_name;
    private String interest;

    /**
     * Get the activity ID.
     *
     * @return the activityID
     */
    public Integer getActivityID() {
        return activityID;
    }

    /**
     * Set the activity ID.
     *
     * @param activityID the activityID to set
     */
    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    /**
     * Get the activity name.
     *
     * @return the activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Set the activity name.
     *
     * @param activityName the activityName to set
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
