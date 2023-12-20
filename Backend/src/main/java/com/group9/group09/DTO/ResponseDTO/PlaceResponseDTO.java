package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Activity;
import com.group9.group09.model.City;
import com.group9.group09.model.Place;

import java.util.List;

public class PlaceResponseDTO {
    private Integer placeID;
    private String placeName;

    private String description;
    private String interest;
    private List<Activity> activityObjectsResponseList;

    private String placeImageLink;


    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Activity> getActivityObjectsResponseList() {
        return activityObjectsResponseList;
    }

    public void setActivityObjectsResponseList(List<Activity> activityObjectsResponseList) {
        this.activityObjectsResponseList = activityObjectsResponseList;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPlaceImageLink() {
        return placeImageLink;
    }

    public void setPlaceImageLink(String placeImageLink) {
        this.placeImageLink = placeImageLink;
    }
}
