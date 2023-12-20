package com.group9.group09.DTO.RequestDTO;

import com.group9.group09.model.User;

public class UserEditRequestDTO extends RequestDTO {
    private User user;
    private String email;
    private String password;
    private String newEmail;
    private String newpassword;
    private String newHomeCountry;
    private String newContactno;
    private String newusername;


    /**
     * Get the current email of the user.
     *
     * @return The current email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the current email of the user.
     *
     * @param email The current email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the current password of the user.
     *
     * @return The current password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the current password of the user.
     *
     * @param password The current password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user entity containing the existing user details.
     *
     * @return The user entity.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user entity containing the existing user details.
     *
     * @param user The user entity to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the new email to be updated.
     *
     * @return The new email.
     */
    public String getNewEmail() {
        return newEmail;
    }

    /**
     * Set the new email to be updated.
     *
     * @param newEmail The new email to set.
     */
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    /**
     * Get the new password to be updated.
     *
     * @return The new password.
     */
    public String getNewpassword() {
        return newpassword;
    }

    /**
     * Set the new password to be updated.
     *
     * @param newpassword The new password to set.
     */
    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    /**
     * Get the new home country to be updated.
     *
     * @return The new home country.
     */
    public String getNewHomeCountry() {
        return newHomeCountry;
    }

    /**
     * Set the new home country to be updated.
     *
     * @param newHomeCountry The new home country to set.
     */
    public void setNewHomeCountry(String newHomeCountry) {
        this.newHomeCountry = newHomeCountry;
    }

    /**
     * Get the new contact number to be updated.
     *
     * @return The new contact number.
     */
    public String getNewContactno() {
        return newContactno;
    }

    /**
     * Set the new contact number to be updated.
     *
     * @param newContactno The new contact number to set.
     */
    public void setNewContactno(String newContactno) {
        this.newContactno = newContactno;
    }

    /**
     * Get the new username to be updated.
     *
     * @return The new username.
     */
    public String getNewusername() {
        return newusername;
    }

    /**
     * Set the new username to be updated.
     *
     * @param newusername The new username to set.
     */
    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }
}
