package com.hexaware.exception;

@SuppressWarnings("serial")
public class InvalidProductException extends Throwable{
	public InvalidProductException(String message)
	{
		super(message);
	}
}
