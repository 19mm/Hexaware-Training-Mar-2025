package com.hexaware.exception;
import java.util.Scanner;

public class exception2 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name");
		
		String name = sc.nextLine();
	
	    if(name.startsWith("m")) 
	    {
	    	System.out.println("name is valid");
	    }
	    else
	    {
	    	try 
	    	{
	    		throw new ArithmeticException();
	    	}
	    	catch(ArithmeticException ae)
	    	{
	    		System.out.println("name should start with m letter");
	    	}
	    }
	}
}
