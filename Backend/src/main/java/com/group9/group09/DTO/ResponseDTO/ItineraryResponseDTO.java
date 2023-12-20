package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Itinerary;

import java.util.List;

/**
 * Data Transfer Object for Itinerary Response.
 */
public class ItineraryResponseDTO {



    private String message ;
    private List<Itinerary> itineraryObjectList;

    /**
     * Get the list of itinerary objects from the itinerary response.
     *
     * @return the list of itinerary objects
     */
    public List<Itinerary> getItineraryObjectList() {
        return itineraryObjectList;
    }

    /**
     * Set the list of itinerary objects in the itinerary response.
     *
     * @param itineraryObjectList the list of itinerary objects to set
     */
    public void setItineraryObjectList(List<Itinerary> itineraryObjectList) {
        this.itineraryObjectList = itineraryObjectList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
