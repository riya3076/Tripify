package com.group9.group09.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.group9.group09.DTO.RequestDTO.ItineraryRequestDTO;
import com.group9.group09.model.Itinerary;
import com.group9.group09.repository.ItineraryRespositoryImp;
import com.group9.group09.repository.interfaces.ItineraryRepository;
import com.group9.group09.repository.rowmapper.ItineraryRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
class ItineraryRespositoryImpTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ItineraryRespositoryImp itineraryRepository;

    private Itinerary testItinerary;
    private ItineraryRequestDTO testItineraryRequestDTO;

    @BeforeEach
    public void setup() {
        testItinerary = new Itinerary();
        testItineraryRequestDTO = new ItineraryRequestDTO();
    }

    @Test
    public void testGetItineraryList_ExistingItineraries_ReturnsListOfItineraries() {
        List<Itinerary> itineraryList = new ArrayList<>();
        itineraryList.add(testItinerary);

        when(jdbcTemplate.query(anyString(), any(ItineraryRowMapper.class), anyInt())).thenReturn(itineraryList);

        List<Itinerary> result = itineraryRepository.getItineraryList(1);

        assertEquals(itineraryList, result);

        verify(jdbcTemplate).query(anyString(), any(ItineraryRowMapper.class), eq(1));
    }

    @Test
    public void testGetItineraryList_NoItineraries_ReturnsEmptyList() {
        when(jdbcTemplate.query(anyString(), any(ItineraryRowMapper.class), anyInt())).thenReturn(new ArrayList<>());

        List<Itinerary> result = itineraryRepository.getItineraryList(1);

        assertTrue(result.isEmpty());

        verify(jdbcTemplate).query(anyString(), any(ItineraryRowMapper.class), eq(1));
    }

    @Test
    public void testAddToItinerary_ValidRequestDTO_ReturnsRowsAffected() {
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int result = itineraryRepository.addtoItinerary(testItineraryRequestDTO);

        assertEquals(1, result);

        verify(jdbcTemplate).update(anyString(), any(), any(), any(), any(), any(), any());
    }

    @Test
    public void testAddToItinerary_ExceptionInJdbcTemplate_ThrowsRuntimeException() {
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any(), any())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> itineraryRepository.addtoItinerary(testItineraryRequestDTO));

        verify(jdbcTemplate).update(anyString(), any(), any(), any(), any(), any(), any());
    }

    @Test
    public void testDeleteItineraryById_ValidId_ReturnsRowsAffected() {
        when(jdbcTemplate.update(anyString(), anyInt())).thenReturn(1);

        int result = itineraryRepository.deleteitinerarybyid(1);

        assertEquals(1, result);

        verify(jdbcTemplate).update(anyString(), anyInt());
    }

    @Test
    public void testDeleteItineraryById_ExceptionInJdbcTemplate_ThrowsRuntimeException() {
        when(jdbcTemplate.update(anyString(), anyInt())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> itineraryRepository.deleteitinerarybyid(1));

        verify(jdbcTemplate).update(anyString(), anyInt());
    }
}