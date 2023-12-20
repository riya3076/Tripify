package com.group9.group09.service;

import com.group9.group09.DTO.RequestDTO.OTPRequestDTO;
import com.group9.group09.config.interfaces.EmailConfig;
import com.group9.group09.model.EmailDetails;
import com.group9.group09.service.interfaces.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Service implementation for OTP (One-Time Password) operations.
 */
@Service
public class OTPServiceImpl implements OTPService {

    private static long allowedTimeDifference = 5 * 60 * 1000;
    private static String otp;
    private static long startTime;
    @Autowired
    private EmailConfig emailConfig;

    /**
     * Get the generated OTP.
     *
     * @return the generated OTP
     */
    public static String getOtp() {
        return otp;
    }

    @Override
    public boolean generateOTP(String email) {

        try {
            Random random = new Random();
            int min = 1000;
            int max = 9999;
            Integer otp = random.nextInt(max - min)+ min;
            OTPServiceImpl.otp = otp.toString();

            startTime = System.currentTimeMillis();

            EmailDetails details = new EmailDetails();
            details.setSubject("Tripify OTP Verification");
            details.setMsgBody("Your OTP for the tripify verification is " + otp.toString());
            details.setRecipient(email);

            emailConfig.sendMail(details);

            return true;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public boolean verifyUserUsingOTP(OTPRequestDTO requestDTO) {

        try {
            long endTime = System.currentTimeMillis();
            long timeDifference = startTime - endTime;
            if (timeDifference <= allowedTimeDifference) {
                if (requestDTO.getOtp().equalsIgnoreCase(getOtp()))
                    return true;
                else
                    return false;
            } else {
                throw new RuntimeException("OTP Expired");
            }
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}