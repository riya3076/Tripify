package com.group9.group09.repositoryTest;

import com.group9.group09.exception.CountryNotFoundException;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.Country;
import com.group9.group09.repository.CountryRepositoryImp;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.rowmapper.CountryRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CountryRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private CountryRepository countryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        countryRepository = new CountryRepositoryImp(jdbcTemplate);
    }
    @Test
    void testAddCountry() {
        String countryName = "Country 1";
        String description = "Description 1";
        int rowsAffected = 1;
        when(jdbcTemplate.update(anyString(), eq(countryName), eq(description))).thenReturn(rowsAffected);

        int result = countryRepository.addCountry(countryName, description);

        assertEquals(rowsAffected, result);
    }

    @Test
    void testFindByCountryIdNotFound() {
        int countryId = 1;
        when(jdbcTemplate.queryForObject(anyString(), any(CountryRowMapper.class), eq(countryId))).thenReturn(null);

        Optional<Country> result = countryRepository.findByCountryId(countryId);

        assertEquals(Optional.empty(), result);
    }

    @Test
    void testFindByCountryNameNotFound() {
        String countryName = "Non-existent Country";
        when(jdbcTemplate.queryForObject(anyString(), any(CountryRowMapper.class), eq(countryName))).thenReturn(null);

        Optional<Country> result = countryRepository.findByCountryName(countryName);

        assertEquals(Optional.empty(), result);
    }

    @Test
    void testAddCountryFailure() {
        String countryName = "Country 1";
        String description = "Description 1";
        when(jdbcTemplate.update(anyString(), eq(countryName), eq(description))).thenThrow(new RuntimeException("Database connection error"));

        assertThrows(CountryNotFoundException.class, () -> countryRepository.addCountry(countryName, description));
    }

    @Test
    void testGetCountriesFailure() {
        when(jdbcTemplate.query(anyString(), any(CountryRowMapper.class))).thenThrow(new RuntimeException("Database connection error"));

        assertThrows(RuntimeException.class, () -> countryRepository.getCountries());
    }
}