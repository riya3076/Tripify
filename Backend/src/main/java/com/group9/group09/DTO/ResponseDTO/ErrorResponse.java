package com.group9.group09.DTO.ResponseDTO;

/**
 * Data Transfer Object for Error Response.
 */
public class ErrorResponse {

    private String message;

    /**
     * Get the error message from the response.
     *
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the error message in the response.
     *
     * @param message the error message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
