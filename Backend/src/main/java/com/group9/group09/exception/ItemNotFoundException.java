package com.group9.group09.exception;

/**
 * Custom exception class to indicate that an item is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class ItemNotFoundException extends RuntimeException {

    /**
     * Constructs a new ItemNotFoundException with no specified error message.
     */
    public ItemNotFoundException() {
        super();
    }

    /**
     * Constructs a new ItemNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
