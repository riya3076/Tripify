package com.group9.group09.DTO.RequestDTO;
/**
 * Data Transfer Object (DTO) class for requesting information related to places.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class PlaceRequestDTO extends RequestDTO {

    private Integer placeID;
    private String placeName;
    private String description;
    private Integer cityId;
    private String cityName;
    private String interest;

    /**
     * Get the ID of the place.
     *
     * @return The place ID.
     */
    public Integer getPlaceID() {
        return placeID;
    }

    /**
     * Set the ID of the place.
     *
     * @param placeID The place ID to set.
     */
    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    /**
     * Get the name of the place.
     *
     * @return The place name.
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * Set the name of the place.
     *
     * @param placeName The place name to set.
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
     * Get the description of the place.
     *
     * @return The place description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the place.
     *
     * @param description The place description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the ID of the city where the place is located.
     *
     * @return The city ID.
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Set the ID of the city where the place is located.
     *
     * @param cityId The city ID to set.
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * Get the name of the city where the place is located.
     *
     * @return The city name.
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set the name of the city where the place is located.
     *
     * @param cityName The city name to set.
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Get the interest associated with the place.
     *
     * @return The place interest.
     */
    public String getInterest() {
        return interest;
    }

    /**
     * Set the interest associated with the place.
     *
     * @param interest The place interest to set.
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }
}
