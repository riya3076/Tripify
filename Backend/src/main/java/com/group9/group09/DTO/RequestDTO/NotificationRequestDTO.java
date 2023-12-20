package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object (DTO) class for requesting notification-related information.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class NotificationRequestDTO extends RequestDTO {

    private String userName;

    /**
     * Get the username associated with the notification request.
     *
     * @return The username string.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the username for the notification request.
     *
     * @param userName The username string to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
