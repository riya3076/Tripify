package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.RequestDTO.OTPRequestDTO;

/**
 * Service interface for OTP (One-Time Password) operations.
 */
public interface OTPService {

    /**
     * Generate OTP for the given email.
     *
     * @param email the email for which OTP is to be generated
     * @return true if OTP is generated successfully, false otherwise
     */
    boolean generateOTP(String email);

    /**
     * Verify the user using the provided OTP.
     *
     * @param requestDTO the OTP request data transfer object
     * @return true if the user is verified successfully, false otherwise
     */
    boolean verifyUserUsingOTP(OTPRequestDTO requestDTO);
}