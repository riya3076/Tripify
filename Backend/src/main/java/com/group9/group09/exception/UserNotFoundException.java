package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a user is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Constructs a new UserNotFoundException with no specified error message.
     */
    public UserNotFoundException() {
        super();
    }

    /**
     * Constructs a new UserNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
