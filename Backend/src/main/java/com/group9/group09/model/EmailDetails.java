package com.group9.group09.model;

/**
 * Model class to hold email details.
 */
public class EmailDetails {

    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

    /**
     * Get the recipient's email address.
     *
     * @return the recipient's email address
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Set the recipient's email address.
     *
     * @param recipient the recipient's email address to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Get the email message body.
     *
     * @return the email message body
     */
    public String getMsgBody() {
        return msgBody;
    }

    /**
     * Set the email message body.
     *
     * @param msgBody the email message body to set
     */
    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    /**
     * Get the email subject.
     *
     * @return the email subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the email subject.
     *
     * @param subject the email subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Get the path to the email attachment.
     *
     * @return the path to the email attachment
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * Set the path to the email attachment.
     *
     * @param attachment the path to the email attachment to set
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}