package com.group9.group09.repository.interfaces;

import com.group9.group09.model.ReviewsActivity;
import com.group9.group09.model.ReviewsPlace;

import java.util.List;

public interface ReviewsActivityRepository {
    List<ReviewsActivity> getReviewsActivitybyActivityId(Integer activityId);
}
