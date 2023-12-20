package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a review is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class ReviewNotFoundException extends RuntimeException {

    /**
     * Constructs a new ReviewNotFoundException with no specified error message.
     */
    public ReviewNotFoundException() {
        super();
    }

    /**
     * Constructs a new ReviewNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
