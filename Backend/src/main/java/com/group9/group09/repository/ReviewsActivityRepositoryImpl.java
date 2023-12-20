package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.ReviewNotFoundException;
import com.group9.group09.model.ReviewsActivity;
import com.group9.group09.repository.interfaces.ReviewsActivityRepository;
import com.group9.group09.repository.rowmapper.ReviewsActivityRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * Repository implementation for handling reviews related to activities.
 */
@Repository
public class ReviewsActivityRepositoryImpl implements ReviewsActivityRepository {
        private final JdbcTemplate jdbcTemplate;
        private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of ReviewsActivityRepositoryImpl with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
        public ReviewsActivityRepositoryImpl(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

    /**
     * Get the list of reviews associated with a specific activity ID.
     *
     * @param activityId The ID of the activity for which to retrieve the reviews.
     * @return A list of reviews associated with the specified activity ID.
     * @throws ReviewNotFoundException If there are no reviews found for the activity ID or there was an error while fetching reviews from the database.
     */
        @Override
        public List<ReviewsActivity> getReviewsActivitybyActivityId(Integer activityId) {
            try {
                logger.info("Info Message: ");
                String getReviewsPlaceByReviewId = "Select * from ReviewsActivity where activity_id = ?";
                return jdbcTemplate.query(getReviewsPlaceByReviewId, new ReviewsActivityRowMapper(), activityId);
            } catch (Exception e) {
                logger.error("Error Message: ");
                throw new ReviewNotFoundException(e.getMessage());
            }
        }
}
