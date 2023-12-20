package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a state is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class StateNotFoundException extends RuntimeException {

    /**
     * Constructs a new StateNotFoundException with no specified error message.
     */
    public StateNotFoundException() {
        super();
    }

    /**
     * Constructs a new StateNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public StateNotFoundException(String message) {
        super(message);
    }
}
