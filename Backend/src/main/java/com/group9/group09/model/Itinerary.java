package com.group9.group09.model;

import javax.xml.transform.sax.SAXResult;
import java.util.Date;

public class Itinerary {
    private Integer itineraryid;
    private Integer userid;
    private String startdate;
    private String endDate;
    private String title;

    /**
     * Get the ID of the itinerary.
     *
     * @return the itineraryid
     */
    public Integer getItineraryid() {
        return itineraryid;
    }

    /**
     * Set the ID of the itinerary.
     *
     * @param itineraryid the itineraryid to set
     */
    public void setItineraryid(Integer itineraryid) {
        this.itineraryid = itineraryid;
    }

    /**
     * Get the ID of the user.
     *
     * @return the userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Set the ID of the user.
     *
     * @param userid the userid to set
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * Get the start date of the itinerary.
     *
     * @return the startdate
     */
    public String getStartdate() {
        return startdate;
    }

    /**
     * Set the start date of the itinerary.
     *
     * @param startdate the startdate to set
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    /**
     * Get the end date of the itinerary.
     *
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Set the end date of the itinerary.
     *
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}