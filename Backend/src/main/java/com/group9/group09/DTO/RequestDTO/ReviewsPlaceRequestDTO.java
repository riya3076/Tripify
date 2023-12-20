package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object (DTO) class for requesting reviews related to a place.
 * Extends the base RequestDTO class to inherit common request properties.
 */
public class ReviewsPlaceRequestDTO extends RequestDTO {

    private Integer user_id;
    private Integer rating;
    private Integer place_id;
    private String review_message;
    private Integer activity_id;

    /**
     * Get the ID of the place for which reviews are requested.
     *
     * @return The place ID.
     */
    public Integer getPlace_id() {
        return place_id;
    }

    /**
     * Set the ID of the place for which reviews are requested.
     *
     * @param place_id The place ID to set.
     */
    public void setPlace_id(Integer place_id) {
        this.place_id = place_id;
    }

    /**
     * Get the ID of the user who submitted the review.
     *
     * @return The user ID.
     */
    public Integer getUserid() {
        return user_id;
    }

    /**
     * Set the ID of the user who submitted the review.
     *
     * @param user_id The user ID to set.
     */
    public void setUserid(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * Get the review message.
     *
     * @return The review message.
     */
    public String getReview_message() {
        return review_message;
    }

    /**
     * Set the review message.
     *
     * @param review_message The review message to set.
     */
    public void setReview_message(String review_message) {
        this.review_message = review_message;
    }

    /**
     * Get the rating associated with the review.
     *
     * @return The review rating.
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * Set the rating associated with the review.
     *
     * @param rating The review rating to set.
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * Get the ID of the activity related to the place.
     *
     * @return The activity ID.
     */
    public Integer getActivity_id() {
        return activity_id;
    }

    /**
     * Set the ID of the activity related to the place.
     *
     * @param activity_id The activity ID to set.
     */
    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    /**
     * Get the ID of the user who submitted the review.
     *
     * @return The user ID.
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * Set the ID of the user who submitted the review.
     *
     * @param user_id The user ID to set.
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

}
