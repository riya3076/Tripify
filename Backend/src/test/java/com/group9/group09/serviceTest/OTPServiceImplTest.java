package com.group9.group09.serviceTest;


import com.group9.group09.DTO.RequestDTO.OTPRequestDTO;
import com.group9.group09.config.interfaces.EmailConfig;
import com.group9.group09.model.EmailDetails;
import com.group9.group09.service.OTPServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OTPServiceImplTest {

    @Mock
    private EmailConfig emailConfig;

    @InjectMocks
    private OTPServiceImpl otpService;

    private String testEmail = "test@example.com";

    @Test
    public void testVerifyUserUsingInvalidOTP() {
        OTPRequestDTO requestDTO = new OTPRequestDTO();
        requestDTO.setOtp("0000");
        OTPServiceImpl otpService = new OTPServiceImpl();

        boolean result = otpService.verifyUserUsingOTP(requestDTO);
        assertFalse(result);
    }
}