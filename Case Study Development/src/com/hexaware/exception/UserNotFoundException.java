//User Defied Exception, thrown when user wirh specific ID is not found
package com.hexaware.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
