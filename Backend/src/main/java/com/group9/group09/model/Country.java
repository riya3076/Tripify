package com.group9.group09.model;

public class Country {
    private Integer countryID;
    private String countryName;
    private String description;
    private String countryImageLink;


    /**
     * Get the ID of the country.
     *
     * @return the countryID
     */
    public Integer getCountryID() {
        return countryID;
    }

    /**
     * Set the ID of the country.
     *
     * @param countryID the countryID to set
     */
    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    /**
     * Get the name of the country.
     *
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set the name of the country.
     *
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Get the description of the country.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the country.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryImageLink() {
        return countryImageLink;
    }

    public void setCountryImageLink(String countryImageLink) {
        this.countryImageLink = countryImageLink;
    }
}
