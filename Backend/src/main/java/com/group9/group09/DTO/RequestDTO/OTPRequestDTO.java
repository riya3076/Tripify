package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object for OTP Request.
 */
public class OTPRequestDTO {
    private String otp;

    /**
     * Get the OTP value.
     *
     * @return the OTP value
     */
    public String getOtp() {
        return otp;
    }

    /**
     * Set the OTP value.
     *
     * @param otp the OTP value to set
     */
    public void setOtp(String otp) {
        this.otp = otp;
    }
}
