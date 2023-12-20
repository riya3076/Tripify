package com.group9.group09.DTO.ResponseDTO;

/**
 * Data Transfer Object for Response.
 */
public class ResponseDTO {

    private String token;
    private String email;
    private String success;
    private String message;

    /**
     * Get the success status.
     *
     * @return the success status
     */
    public String getSuccess() {
        return success;
    }

    /**
     * Set the success status.
     *
     * @param success the success status to set
     */
    public void setSuccess(String success) {
        this.success = success;
    }

    /**
     * Get the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token.
     *
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Get the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
