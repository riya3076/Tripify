package com.group9.group09.config;

import com.group9.group09.config.interfaces.EmailConfig;
import com.group9.group09.model.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.File;

@Configuration
public class EmailConfigImpl implements EmailConfig {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /**
     * Sends a simple email without attachments.
     *
     * @param email The email details, including recipient and message body.
     * @return true if the email was sent successfully, otherwise false.
     */

    @Override
    public boolean sendMail(EmailDetails email) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();

            msg.setFrom(sender);
            msg.setSubject(email.getMsgBody());
            msg.setTo(email.getRecipient());
            msg.setText(email.getMsgBody());

            javaMailSender.send(msg);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error sending email");
        }
    }


    /**
     * Sends an email with attachments.
     *
     * @param email The email details, including recipient, message body, and file attachment.
     * @return true if the email was sent successfully, otherwise false.
     */

    @Override
    public boolean sendMailIncludingFiles(EmailDetails email) {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper msgHelper;

        try {
            msgHelper = new MimeMessageHelper(msg, true);
            msgHelper.setFrom(sender);
            msgHelper.setTo(email.getRecipient());
            msgHelper.setText(email.getMsgBody());
            msgHelper.setSubject(email.getSubject());

            FileSystemResource file = new FileSystemResource(
                    new File(email.getAttachment()));

            msgHelper.addAttachment(file.getFilename(), file);

            javaMailSender.send(msg);
            return true;
        }
        catch (Exception e) {
            throw new RuntimeException("Error sending email");
        }
    }
}