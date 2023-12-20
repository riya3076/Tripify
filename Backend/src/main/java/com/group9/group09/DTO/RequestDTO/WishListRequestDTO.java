package com.group9.group09.DTO.RequestDTO;

public class WishListRequestDTO extends RequestDTO{

    private Integer wishlistid;
    private Integer userid;
    private Integer placeId;
    private Integer activityId;
    private String placename;
    private String activityname;
    private String cityName;
    private Integer cityid;

    /**
     * Get the ID of the user who owns the wishlist item.
     *
     * @return The ID of the user who owns the wishlist item.
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Set the ID of the user who owns the wishlist item.
     *
     * @param userid The ID to set.
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * Get the ID of the place associated with the wishlist item.
     *
     * @return The ID of the place associated with the wishlist item.
     */
    public Integer getPlaceId() {
        return placeId;
    }

    /**
     * Set the ID of the place associated with the wishlist item.
     *
     * @param placeId The ID to set.
     */
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    /**
     * Get the ID of the activity associated with the wishlist item.
     *
     * @return The ID of the activity associated with the wishlist item.
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * Set the ID of the activity associated with the wishlist item.
     *
     * @param activityId The ID to set.
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * Get the name of the place associated with the wishlist item.
     *
     * @return The name of the place associated with the wishlist item.
     */
    public String getPlacename() {
        return placename;
    }

    /**
     * Set the name of the place associated with the wishlist item.
     *
     * @param placename The name to set.
     */
    public void setPlacename(String placename) {
        this.placename = placename;
    }

    /**
     * Get the name of the activity associated with the wishlist item.
     *
     * @return The name of the activity associated with the wishlist item.
     */
    public String getActivityname() {
        return activityname;
    }

    /**
     * Set the name of the activity associated with the wishlist item.
     *
     * @param activityname The name to set.
     */
    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    /**
     * Get the name of the city associated with the wishlist item.
     *
     * @return The name of the city associated with the wishlist item.
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set the name of the city associated with the wishlist item.
     *
     * @param cityName The name to set.
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    /**
     * Get the ID of the city associated with the wishlist item.
     *
     * @return The ID of the city associated with the wishlist item.
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * Set the ID of the city associated with the wishlist item.
     *
     * @param cityid The ID to set.
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * Get the ID of the wishlist item.
     *
     * @return The ID of the wishlist item.
     */
    public Integer getWishlistid() {
        return wishlistid;
    }

    /**
     * Set the ID of the wishlist item.
     *
     * @param wishlistid The ID to set.
     */
    public void setWishlistid(Integer wishlistid) {
        this.wishlistid = wishlistid;
    }
}
