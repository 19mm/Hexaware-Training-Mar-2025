//User Defined Exception Handling when Policy with Specified "Id" is not Found in DB

package com.hexaware.exception;

@SuppressWarnings("serial")
public class PolicyNotFoundException extends Exception {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}
