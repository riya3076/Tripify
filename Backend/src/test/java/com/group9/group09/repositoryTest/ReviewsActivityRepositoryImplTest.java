package com.group9.group09.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.group9.group09.model.ReviewsActivity;
import com.group9.group09.repository.ReviewsActivityRepositoryImpl;
import com.group9.group09.repository.rowmapper.ReviewsActivityRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReviewsActivityRepositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ReviewsActivityRepositoryImpl reviewsActivityRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReviewsActivitybyActivityId() {
        int activityId = 1;
        List<ReviewsActivity> expectedReviews = List.of(new ReviewsActivity(), new ReviewsActivity());

        when(jdbcTemplate.query(anyString(), any(ReviewsActivityRowMapper.class), eq(activityId)))
                .thenReturn(expectedReviews);

        List<ReviewsActivity> result = reviewsActivityRepository.getReviewsActivitybyActivityId(activityId);

        assertEquals(expectedReviews, result);
    }

    @Test
    public void testGetReviewsActivitybyActivityIdError() {
        int activityId = 1;

        when(jdbcTemplate.query(anyString(), any(ReviewsActivityRowMapper.class), eq(activityId)))
                .thenThrow(new RuntimeException("Test Exception"));

        assertThrows(RuntimeException.class, () -> reviewsActivityRepository.getReviewsActivitybyActivityId(activityId));
    }
}