package com.group9.group09.serviceTest;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.model.*;
import com.group9.group09.repository.interfaces.*;
import com.group9.group09.service.AdminServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdminServiceImplTest {

    @Mock
    private CountryRepository countryRepository;

    @Mock
    private StateRepository stateRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private AdminServiceImp adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCountryService_CountryAlreadyPresent() {
        CountryRequestDTO countryRequestDTO = new CountryRequestDTO();
        countryRequestDTO.setCountry_name("Test Country");

        // Mock countryRepository's findByCountryName method to return a non-empty Optional
        when(countryRepository.findByCountryName(countryRequestDTO.getCountry_name()))
                .thenReturn(Optional.of(new Country()));

        ResponseDTO responseDTO = adminService.addCountryService(countryRequestDTO);

        assertEquals("Country already present", responseDTO.getMessage());
        verify(countryRepository, times(1)).findByCountryName(countryRequestDTO.getCountry_name());
        verify(countryRepository, never()).addCountry(any(), any());
    }

    @Test
    void testAddCountryService_NullCountryName() {
        CountryRequestDTO countryRequestDTO = new CountryRequestDTO();

        // Ensure that the method throws a RuntimeException when country_name is null
        assertThrows(RuntimeException.class, () -> adminService.addCountryService(countryRequestDTO));

        verify(countryRepository, never()).findByCountryName(any());
        verify(countryRepository, never()).addCountry(any(), any());
    }

}
