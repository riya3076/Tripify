package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.ReviewsActivity;
import com.group9.group09.model.ReviewsPlace;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewsActivityRowMapper implements RowMapper<ReviewsActivity> {
    @Override
    public ReviewsActivity mapRow(ResultSet rs, int rowNum) throws SQLException {

        ReviewsActivity reviewsActivity = new ReviewsActivity();
        reviewsActivity.setReviewActivityID(rs.getInt("reviews_activity_id"));
        reviewsActivity.setUserID(rs.getInt("user_id"));
        reviewsActivity.setActivityId(rs.getInt("activity_id"));
        reviewsActivity.setRating(rs.getDouble("rating"));
        reviewsActivity.setReviewactivityComment(rs.getString("review_message"));
        reviewsActivity.setDateofreview(rs.getDate("dateofreview"));

        return reviewsActivity;
    }
}
