package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.ReviewsPlace;
import com.group9.group09.model.wishList;

import java.util.List;

public class ReviewsPlaceResponseDTO {
    private List<ReviewsPlace> reviewsPlaces;
    private String message;

    public List<ReviewsPlace> getReviewsPlaces() {
        return reviewsPlaces;
    }

    public void setReviewsPlaces(List<ReviewsPlace> reviewsPlaces) {
        this.reviewsPlaces = reviewsPlaces;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
