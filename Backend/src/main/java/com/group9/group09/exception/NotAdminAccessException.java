package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a user does not have administrative access.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class NotAdminAccessException extends RuntimeException {

    /**
     * Constructs a new NotAdminAccessException with no specified error message.
     */
    public NotAdminAccessException() {
        super();
    }

    /**
     * Constructs a new NotAdminAccessException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public NotAdminAccessException(String message) {
        super(message);
    }
}
