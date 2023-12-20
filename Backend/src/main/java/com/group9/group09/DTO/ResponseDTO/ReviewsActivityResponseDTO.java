package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.ReviewsActivity;

import java.util.List;

public class ReviewsActivityResponseDTO {
    private List<ReviewsActivity> reviewsActivities;

    public List<ReviewsActivity> getReviewsActivities() {
        return reviewsActivities;
    }

    public void setReviewsActivities(List<ReviewsActivity> reviewsActivities) {
        this.reviewsActivities = reviewsActivities;
    }
}
