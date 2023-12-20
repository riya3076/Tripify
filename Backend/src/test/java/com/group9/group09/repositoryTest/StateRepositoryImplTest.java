package com.group9.group09.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.group9.group09.model.State;
import com.group9.group09.repository.StateRepositoryImp;
import com.group9.group09.repository.rowmapper.StateRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class StateRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private StateRepositoryImp stateRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByStateId() {
        int stateId = 1;
        State expectedState = new State();

        when(jdbcTemplate.queryForObject(anyString(), any(StateRowMapper.class), eq(stateId)))
                .thenReturn(expectedState);

        Optional<State> result = stateRepository.findByStateId(stateId);

        assertTrue(result.isPresent());
        assertEquals(expectedState, result.get());
    }

    @Test
    public void testFindByStateIdNotFound() {
        int stateId = 1;

        when(jdbcTemplate.queryForObject(anyString(), any(StateRowMapper.class), eq(stateId)))
                .thenReturn(null);

        Optional<State> result = stateRepository.findByStateId(stateId);

        assertFalse(result.isPresent());
    }

    @Test
    public void testGetStatesbyCountryID() {
        int countryId = 1;
        List<State> expectedStates = List.of(new State(), new State());

        when(jdbcTemplate.query(anyString(), any(StateRowMapper.class), eq(countryId)))
                .thenReturn(expectedStates);

        List<State> result = stateRepository.getStatesbyCountryID(countryId);

        assertEquals(expectedStates, result);
    }

    @Test
    public void testAddState() {
        String stateName = "State1";
        String description = "Description";
        int countryId = 1;


        when(jdbcTemplate.update(anyString(), eq(stateName), eq(description), eq(countryId)))
                .thenReturn(1);

        int result = stateRepository.addState(stateName, description, countryId);

        assertEquals(1, result);
    }
}