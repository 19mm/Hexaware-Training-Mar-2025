//User Defined Exception, thrown when Artwork with Specifeid ID is not found
package com.hexaware.exception;

@SuppressWarnings("serial")
public class ArtWorkNotFoundException extends Exception {
    public ArtWorkNotFoundException(String message) {
        super(message);
    }
}
