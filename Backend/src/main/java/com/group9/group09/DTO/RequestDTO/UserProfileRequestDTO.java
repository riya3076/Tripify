package com.group9.group09.DTO.RequestDTO;

public class UserProfileRequestDTO extends RequestDTO{

    private String name;
    private String email;
    private String phoneNumber;
    private String interests;
    private String country;
    private String verifiedStatus;

    /**
     * Get the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the user.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the user.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the interests of the user.
     *
     * @return The interests of the user.
     */
    public String getInterests() {
        return interests;
    }

    /**
     * Set the interests of the user.
     *
     * @param interests The interests to set.
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * Get the country of the user.
     *
     * @return The country of the user.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set the country of the user.
     *
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get the verified status of the user.
     *
     * @return The verified status of the user.
     */
    public String getVerifiedStatus() {
        return verifiedStatus;
    }

    /**
     * Set the verified status of the user.
     *
     * @param verifiedStatus The verified status to set.
     */
    public void setVerifiedStatus(String verifiedStatus) {
        this.verifiedStatus = verifiedStatus;
    }
}
