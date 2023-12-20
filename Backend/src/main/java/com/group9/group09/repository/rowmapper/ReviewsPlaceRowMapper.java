package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.ReviewsPlace;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewsPlaceRowMapper implements RowMapper<ReviewsPlace> {
    @Override
    public ReviewsPlace mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReviewsPlace reviewsPlace = new ReviewsPlace();
        reviewsPlace.setReviewPlaceID(rs.getInt("reviews_place_id"));
        System.out.println(reviewsPlace.getReviewPlaceID());
        reviewsPlace.setUserID(rs.getInt("user_id"));
        reviewsPlace.setPlaceID(rs.getInt("place_id"));
        reviewsPlace.setRating(rs.getDouble("rating"));
        reviewsPlace.setReviewplaceComment(rs.getString("review_message"));
        reviewsPlace.setDateofreview(rs.getDate("dateofreview"));

        return reviewsPlace;
    }
}
