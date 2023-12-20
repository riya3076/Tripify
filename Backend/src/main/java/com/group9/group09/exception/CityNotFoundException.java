package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a city is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class CityNotFoundException extends RuntimeException {

    /**
     * Constructs a new CityNotFoundException with no specified error message.
     */
    public CityNotFoundException() {
        super();
    }

    /**
     * Constructs a new CityNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public CityNotFoundException(String message) {
        super(message);
    }
}
