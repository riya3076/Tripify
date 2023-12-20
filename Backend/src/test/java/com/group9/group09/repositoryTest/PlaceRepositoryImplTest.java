package com.group9.group09.repositoryTest;

import com.group9.group09.model.Place;
import com.group9.group09.repository.PlaceRepositoryImp;
import com.group9.group09.repository.interfaces.PlaceRepository;
import com.group9.group09.repository.rowmapper.PlaceRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class PlaceRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PlaceRepository placeRepository = new PlaceRepositoryImp(jdbcTemplate);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


//    @Test
//    void testFindByPlaceId() {
//        int placeId = 1;
//        Place place = new Place();
//        when(jdbcTemplate.queryForObject(anyString(), any(PlaceRowMapper.class), eq(placeId)))
//                .thenReturn(place);
//
//        Optional<Place> result = placeRepository.findByPlaceId(placeId);
//
//        assertEquals(Optional.of(place), result);
//    }
//
//    @Test
//    void testFindByPlaceIdNotFound() {
//        int placeId = 1;
//        when(jdbcTemplate.queryForObject(anyString(), any(PlaceRowMapper.class), eq(placeId)))
//                .thenReturn(null);
//
//        Optional<Place> result = placeRepository.findByPlaceId(placeId);
//
//        assertEquals(Optional.empty(), result);
//    }
//
//    @Test
//    void testFindByPlaceName() {
//        String placeName = "Place 1";
//        Place place = new Place();
//        when(jdbcTemplate.queryForObject(anyString(), any(PlaceRowMapper.class), eq(placeName)))
//                .thenReturn(place);
//
//        Optional<Place> result = placeRepository.findByPlaceName(placeName);
//
//        assertEquals(Optional.of(place), result);
//    }
//
//    @Test
//    void testFindByPlaceNameNotFound() {
//        String placeName = "Non-existent Place";
//        when(jdbcTemplate.queryForObject(anyString(), any(PlaceRowMapper.class), eq(placeName)))
//                .thenReturn(null);
//
//        Optional<Place> result = placeRepository.findByPlaceName(placeName);
//
//        assertEquals(Optional.empty(), result);
//    }
//
//    @Test
//    public void testGetPlacesbyCityID() {
//        int cityId = 1;
//        List<Place> expectedPlaces = List.of(new Place(), new Place());
//        when(jdbcTemplate.query(anyString(), any(PlaceRowMapper.class), eq(cityId)))
//                .thenReturn(expectedPlaces);
//
//        List<Place> result = placeRepository.getPlacesbyCityID(cityId);
//
//        assertEquals(expectedPlaces, result);
//    }
//
//
//    @Test
//    void testGetPlacesByInterest() {
//        String interest = "Adventure";
//        List<Place> places = new ArrayList<>();
//        when(jdbcTemplate.query(anyString(), any(PlaceRowMapper.class), eq(interest)))
//                .thenReturn(places);
//
//        List<Place> result = placeRepository.getPlacesByInterest(interest);
//
//        assertEquals(places, result);
//    }
//
//    @Test
//    void testIsPlacePresent() {
//        String placeName = "Place 1";
//        int cityId = 1;
//        Place place = new Place();
//        when(jdbcTemplate.queryForObject(anyString(), any(PlaceRowMapper.class), eq(placeName), eq(cityId)))
//                .thenReturn(place);
//
//        Optional<Place> result = placeRepository.isPlacePresent(placeName, cityId);
//
//        assertEquals(Optional.of(place), result);
//    }
//
//    @Test
//    void testIsPlacePresentNotFound() {
//        String placeName = "Non-existent Place";
//        int cityId = 1;
//        when(jdbcTemplate.queryForObject(anyString(), any(PlaceRowMapper.class), eq(placeName), eq(cityId)))
//                .thenReturn(null);
//
//        Optional<Place> result = placeRepository.isPlacePresent(placeName, cityId);
//
//        assertEquals(Optional.empty(), result);
//    }
//
//    @Test
//    void testAddPlace() {
//        String placeName = "Place 1";
//        String description = "Description 1";
//        int cityId = 1;
//        String interest = "Adventure";
//        int rowsAffected = 1;
//        when(jdbcTemplate.update(anyString(), eq(placeName), eq(description), eq(cityId), eq(interest)))
//                .thenReturn(rowsAffected);
//
//        int result = placeRepository.addPlace(placeName, description, cityId, interest);
//
//        assertEquals(rowsAffected, result);
//    }

    @Test
    void testAddPlaceFailure() {
        String placeName = "Place 1";
        String description = "Description 1";
        int cityId = 1;
        String interest = "Adventure";
        when(jdbcTemplate.update(anyString(), eq(placeName), eq(description), eq(cityId), eq(interest)))
                .thenReturn(0);

        assertThrows(RuntimeException.class, () -> placeRepository.addPlace(placeName, description, cityId, interest));
    }
}