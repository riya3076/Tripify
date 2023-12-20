package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object (DTO) class for requesting state-related information.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class StateRequestDTO extends RequestDTO {

    private Integer stateID;
    private String stateName;
    private String description;
    private String country_id;
    private String country_name;

    /**
     * Get the ID of the state.
     *
     * @return The state ID.
     */
    public Integer getStateID() {
        return stateID;
    }

    /**
     * Set the ID of the state.
     *
     * @param stateID The state ID to set.
     */
    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    /**
     * Get the name of the state.
     *
     * @return The state name.
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Set the name of the state.
     *
     * @param stateName The state name to set.
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Get the description of the state.
     *
     * @return The state description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the state.
     *
     * @param description The state description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the ID of the country associated with the state.
     *
     * @return The country ID.
     */
    public String getCountry_id() {
        return country_id;
    }

    /**
     * Set the ID of the country associated with the state.
     *
     * @param country_id The country ID to set.
     */
    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    /**
     * Get the name of the country associated with the state.
     *
     * @return The country name.
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * Set the name of the country associated with the state.
     *
     * @param country_name The country name to set.
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
