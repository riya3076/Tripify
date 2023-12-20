package com.group9.group09.model;

public class wishList {
    private Integer wishListID;
    private Integer userID;
    private Integer placeID;
    private Integer activityID;
    private Integer cityID;

    /**
     * Get the ID of the wishlist.
     *
     * @return the wishListID
     */
    public Integer getWishListID() {
        return wishListID;
    }

    /**
     * Set the ID of the wishlist.
     *
     * @param wishListID the wishListID to set
     */
    public void setWishListID(Integer wishListID) {
        this.wishListID = wishListID;
    }

    /**
     * Get the ID of the user.
     *
     * @return the userID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Set the ID of the user.
     *
     * @param userID the userID to set
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Get the ID of the place.
     *
     * @return the placeID
     */
    public Integer getPlaceID() {
        return placeID;
    }

    /**
     * Set the ID of the place.
     *
     * @param placeID the placeID to set
     */
    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    /**
     * Get the ID of the activity.
     *
     * @return the activityID
     */
    public Integer getActivityID() {
        return activityID;
    }

    /**
     * Set the ID of the activity.
     *
     * @param activityID the activityID to set
     */
    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }
}
