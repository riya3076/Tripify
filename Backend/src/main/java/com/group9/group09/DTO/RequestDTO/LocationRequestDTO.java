package com.group9.group09.DTO.RequestDTO;

import java.time.LocalDateTime;
/**
 * Data Transfer Object (DTO) class for requesting location-related information.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class LocationRequestDTO extends RequestDTO {

    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    /**
     * Get the location.
     *
     * @return The location string.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location.
     *
     * @param location The location string to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the start date and time.
     *
     * @return The start date and time as a LocalDateTime object.
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Set the start date and time.
     *
     * @param startDate The start date and time to set as a LocalDateTime object.
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the end date and time.
     *
     * @return The end date and time as a LocalDateTime object.
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Set the end date and time.
     *
     * @param endDate The end date and time to set as a LocalDateTime object.
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
