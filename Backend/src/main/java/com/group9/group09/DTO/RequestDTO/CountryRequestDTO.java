package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object (DTO) class for requesting country-related information.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class CountryRequestDTO extends RequestDTO {
    private String country_name;
    private String description;

    /**
     * Get the name of the country.
     *
     * @return The country name.
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * Set the name of the country.
     *
     * @param country_name The country name to set.
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    /**
     * Get the description of the country.
     *
     * @return The country description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the country.
     *
     * @param description The country description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
