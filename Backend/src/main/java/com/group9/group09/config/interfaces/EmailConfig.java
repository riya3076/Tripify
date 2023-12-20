package com.group9.group09.config.interfaces;

import com.group9.group09.model.EmailDetails;

//  Interface for Email Configuration.
public interface EmailConfig {

    /**
     * Send an email with the provided email details.
     *
     * @param email the EmailDetails object containing email information
     * @return true if the email was sent successfully, false otherwise
     */
    boolean sendMail(EmailDetails email);

    /**
     * Send an email with attachments using the provided email details.
     *
     * @param email the EmailDetails object containing email information and attachments
     * @return true if the email was sent successfully, false otherwise
     */
    boolean sendMailIncludingFiles(EmailDetails email);
}