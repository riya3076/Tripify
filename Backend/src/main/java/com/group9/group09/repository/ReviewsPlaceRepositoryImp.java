package com.group9.group09.repository;


import com.group9.group09.DTO.RequestDTO.ReviewsPlaceRequestDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.ReviewNotFoundException;
import com.group9.group09.model.ReviewsPlace;
import com.group9.group09.repository.interfaces.ReviewsPlaceRepository;
import com.group9.group09.repository.rowmapper.ReviewsPlaceRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository implementation for handling reviews related to places.
 */
@Repository
public class ReviewsPlaceRepositoryImp implements ReviewsPlaceRepository{
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of ReviewsPlaceRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public ReviewsPlaceRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Get the list of reviews associated with a specific place ID.
     *
     * @param placeId The ID of the place for which to retrieve the reviews.
     * @return A list of reviews associated with the specified place ID.
     * @throws ReviewNotFoundException If there are no reviews found for the place ID or there was an error while fetching reviews from the database.
     */
    @Override
    public List<ReviewsPlace> getReviewsPlacebyPlaceId(Integer placeId) {

        try{
            logger.info("Info Message: ");
            String getReviewsPlaceByReviewId = "Select * from ReviewsPlace where place_id = ?";
            return jdbcTemplate.query(getReviewsPlaceByReviewId,new ReviewsPlaceRowMapper(),placeId);
        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new ReviewNotFoundException(e.getMessage());
        }
    }

    /**
     * Add a new review for a place or an activity to the database.
     *
     * @param reviewsPlaceRequestDTO The ReviewPlaceRequestDTO containing the review details.
     * @return The number of rows affected (1 if successful, 0 otherwise). -1 if both place_id and activity_id are null.
     * @throws ReviewNotFoundException If there was an error while adding the review to the database.
     */

    @Override
    public int addReviewplace(ReviewsPlaceRequestDTO reviewsPlaceRequestDTO) {


        if (reviewsPlaceRequestDTO.getActivity_id() == null) {

            try {
                logger.info("Info Message: in ReviewsPlaceRepositoryImp addreviewplace");
                String addReviewsPlace = "INSERT INTO ReviewsPlace (user_id,rating,place_id,`review_message`) VALUES(?,?,?,?);";
                return jdbcTemplate.update(addReviewsPlace, reviewsPlaceRequestDTO.getUserid(), reviewsPlaceRequestDTO.getRating(), reviewsPlaceRequestDTO.getPlace_id(), reviewsPlaceRequestDTO.getReview_message());
            } catch (DataAccessException e) {
                logger.error("Error Message:issue in review place repo ");
                throw new ReviewNotFoundException(e.getMessage());
            }

        } else if (reviewsPlaceRequestDTO.getPlace_id() == null) {
            try {
                logger.info("Info Message: in ReviewsPlaceRepositoryImp addreviewpactivity ");
                String addReviewsactivity = "INSERT INTO ReviewsActivity (user_id,rating,activity_id,`review_message`) VALUES(?,?,?,?);";
                return jdbcTemplate.update(addReviewsactivity, reviewsPlaceRequestDTO.getUserid(), reviewsPlaceRequestDTO.getRating(), reviewsPlaceRequestDTO.getActivity_id(), reviewsPlaceRequestDTO.getReview_message());
            } catch (DataAccessException e) {
                logger.error("Error Message:issue in review place repo ");
                throw new ReviewNotFoundException(e.getMessage());
            }
        } else{
            return -1;
        }
    }
}
