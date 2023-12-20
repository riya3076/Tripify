package com.group9.group09.exception;

/**
 * Custom exception class to indicate that an activity is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class ActivityNotFoundException extends RuntimeException {

    /**
     * Constructs a new ActivityNotFoundException with no specified error message.
     */
    public ActivityNotFoundException() {
        super();
    }

    /**
     * Constructs a new ActivityNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public ActivityNotFoundException(String message) {
        super(message);
    }
}
