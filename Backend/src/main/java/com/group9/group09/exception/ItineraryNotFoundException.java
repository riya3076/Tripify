package com.group9.group09.exception;

/**
 * Custom exception class to indicate that an itinerary is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class ItineraryNotFoundException extends RuntimeException {

    /**
     * Constructs a new ItineraryNotFoundException with no specified error message.
     */
    public ItineraryNotFoundException() {
        super();
    }

    /**
     * Constructs a new ItineraryNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public ItineraryNotFoundException(String message) {
        super(message);
    }
}
