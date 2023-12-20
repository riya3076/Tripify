package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object for City Request.
 */
public class CityRequestDTO extends RequestDTO{

    private Integer cityID;
    private String city;
    private Integer stateid;
    private String stateName;
    private String description;
    private String weather;

    /**
     * Get the city ID from the request.
     *
     * @return the city ID
     */

    public Integer getCityID() {
        return cityID;
    }

    /**
     * Set the city ID in the request.
     *
     * @param cityID the city ID to set
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     * Get the city name from the request.
     *
     * @return the city name
     */
    public String getCity() {
        return city;
    }


    /**
     * Set the city name in the request.
     *
     * @param city the city name to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
