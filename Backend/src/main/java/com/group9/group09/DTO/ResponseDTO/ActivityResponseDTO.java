package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Activity;

import java.util.List;
import java.util.Date;

/**
 * Data Transfer Object for Activity response.
 */
public class ActivityResponseDTO {
    private Integer activityId;
    private String activityName;
    private String activitydesc;
    private String activityLink;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivitydesc() {
        return activitydesc;
    }

    public void setActivitydesc(String activitydesc) {
        this.activitydesc = activitydesc;
    }

    public String getActivityLink() {
        return activityLink;
    }

    public void setActivityLink(String activityLink) {
        this.activityLink = activityLink;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    private List<Activity> activityObjectsResponseList;

    /**
     * Get the list of activity objects in the response.
     *
     * @return the activityObjectsResponseList
     */
    public List<Activity> getActivityObjectsResponseList() {
        return activityObjectsResponseList;
    }


    /**
     * Set the list of activity objects in the response.
     *
     * @param activityObjectsResponseList the activityObjectsResponseList to set
     */
    public void setActivityObjectsResponseList(List<Activity> activityObjectsResponseList) {
        this.activityObjectsResponseList = activityObjectsResponseList;
    }
}
