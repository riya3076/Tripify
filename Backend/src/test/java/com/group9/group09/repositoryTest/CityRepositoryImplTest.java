package com.group9.group09.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group9.group09.exception.CityNotFoundException;
import com.group9.group09.model.City;
import com.group9.group09.repository.CityRepositoryImp;
import com.group9.group09.repository.interfaces.CityRepository;
import com.group9.group09.repository.rowmapper.CityRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
class CityRepositoryImpTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CityRepositoryImp cityRepository;

    private City testCity;

    @BeforeEach
    public void setup() {
        testCity = new City();
    }

    @Test
    public void testFindByCityId_ExistingCityId_ReturnsCity() {
        int cityId = 1;

        when(jdbcTemplate.queryForObject(anyString(), any(CityRowMapper.class), anyInt())).thenReturn(testCity);

        Optional<City> result = cityRepository.findByCityId(cityId);

        assertTrue(result.isPresent());
        assertEquals(testCity, result.get());

        verify(jdbcTemplate).queryForObject(anyString(), any(CityRowMapper.class), eq(cityId));
    }

    @Test
    public void testFindByCityName_ExistingCityName_ReturnsCity() {
        String cityName = "Test City";

        when(jdbcTemplate.queryForObject(anyString(), any(CityRowMapper.class), anyString())).thenReturn(testCity);

        Optional<City> result = cityRepository.findByCityName(cityName);

        assertTrue(result.isPresent());
        assertEquals(testCity, result.get());

        verify(jdbcTemplate).queryForObject(anyString(), any(CityRowMapper.class), eq(cityName));
    }

    @Test
    public void testGetCitiesbyStateID_ExistingStateID_ReturnsListOfCities() {
        int stateID = 1;
        List<City> citiesList = new ArrayList<>();
        citiesList.add(testCity);

        when(jdbcTemplate.query(anyString(), any(CityRowMapper.class), anyInt())).thenReturn(citiesList);

        List<City> result = cityRepository.getCitiesbyStateID(stateID);

        assertEquals(citiesList, result);

        verify(jdbcTemplate).query(anyString(), any(CityRowMapper.class), eq(stateID));
    }

    @Test
    public void testIsCityPresent_ExistingCityAndState_ReturnsCity() {
        String city = "Test City";
        int stateID = 1;

        when(jdbcTemplate.queryForObject(anyString(), any(CityRowMapper.class), anyString(), anyInt())).thenReturn(testCity);

        Optional<City> result = cityRepository.isCityPresent(city, stateID);

        assertTrue(result.isPresent());
        assertEquals(testCity, result.get());

        verify(jdbcTemplate).queryForObject(anyString(), any(CityRowMapper.class), eq(city), eq(stateID));
    }

    @Test
    public void testAddCity_ValidCityData_ReturnsRowCount() {
        String city = "Test City";
        String description = "Test Description";
        int stateID = 1;
        String weather = "Sunny";

        when(jdbcTemplate.update(anyString(), anyString(), anyString(), anyInt(), anyString())).thenReturn(1);

        int result = cityRepository.addCity(city, description, stateID, weather);

        assertEquals(1, result);

        verify(jdbcTemplate).update(anyString(), eq(city), eq(description), eq(stateID), eq(weather));
    }
}
