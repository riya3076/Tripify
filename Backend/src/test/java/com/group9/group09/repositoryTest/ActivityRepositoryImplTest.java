package com.group9.group09.repositoryTest;

import com.group9.group09.model.Activity;
import com.group9.group09.repository.ActivityRepositoryImp;
import com.group9.group09.repository.rowmapper.ActivityRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class ActivityRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ActivityRepositoryImp activityRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByActivityId() {
        int activityId = 1;
        Activity activity = new Activity();
        when(jdbcTemplate.queryForObject(anyString(), any(ActivityRowMapper.class), eq(activityId))).thenReturn(activity);

        Optional<Activity> result = activityRepository.findByActivityId(activityId);

        assertEquals(activity, result.get());
    }

    @Test
    void testAddPlace() {
        String activityName = "Activity 1";
        String description = "Description 1";
        int cityId = 1;
        String interest = "Interest1";

        when(jdbcTemplate.update(anyString(), eq(activityName), eq(description), eq(cityId), eq(interest))).thenReturn(1);

        int result = activityRepository.addPlace(activityName, description, cityId, interest);

        assertEquals(1, result);
    }
}