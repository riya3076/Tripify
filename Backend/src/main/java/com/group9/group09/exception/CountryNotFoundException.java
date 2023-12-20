package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a country is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class CountryNotFoundException extends RuntimeException {

    /**
     * Constructs a new CountryNotFoundException with no specified error message.
     */
    public CountryNotFoundException() {
        super();
    }

    /**
     * Constructs a new CountryNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public CountryNotFoundException(String message) {
        super(message);
    }
}
