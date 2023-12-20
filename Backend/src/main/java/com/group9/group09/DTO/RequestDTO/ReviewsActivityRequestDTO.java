package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object (DTO) class for requesting reviews related to an activity.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class ReviewsActivityRequestDTO extends RequestDTO {

    private Integer activityid;

    /**
     * Get the ID of the activity for which reviews are requested.
     *
     * @return The activity ID.
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * Set the ID of the activity for which reviews are requested.
     *
     * @param activityid The activity ID to set.
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }
}
