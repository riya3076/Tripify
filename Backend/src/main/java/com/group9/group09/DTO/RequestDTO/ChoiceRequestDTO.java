package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object for Choice request.
 */
public class ChoiceRequestDTO extends RequestDTO {

    private String region;

    /**
     * Get the region value from the request.
     *
     * @return the region value
     */
    public String getRegion() {
        return region;
    }

    /**
     * Set the region value in the request.
     *
     * @param region the region value to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
