package com.group9.group09.DTO.RequestDTO;

/**
 * Base Data Transfer Object (DTO) class for common request properties.
 */
public class RequestDTO {

    private String token;

    /**
     * Get the token associated with the request.
     *
     * @return The token string.
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token for the request.
     *
     * @param token The token string to set.
     */
    public void setToken(String token) {
        this.token = token;
    }
}
