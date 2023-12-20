package com.group9.group09.exception;

/**
 * Custom exception class to indicate that a wishlist is not found.
 * Extends the RuntimeException class, which is an unchecked exception.
 */
public class WishlistNotFoundException extends RuntimeException {

    /**
     * Constructs a new WishlistNotFoundException with no specified error message.
     */
    public WishlistNotFoundException() {
        super();
    }

    /**
     * Constructs a new WishlistNotFoundException with the specified error message.
     *
     * @param message The error message explaining the reason for the exception.
     */
    public WishlistNotFoundException(String message) {
        super(message);
    }
}
