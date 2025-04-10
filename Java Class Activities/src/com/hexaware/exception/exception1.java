package com.hexaware.exception;

public class exception1 {
public static void main(String[] args) {
		
		int x = 100;
		int y = 10;
		try {
		int z = x/y;
		System.out.println("division is : " + z);
		}
		
		catch(ArithmeticException ae)
		{
			System.out.println("don't enter zero as denominator");
		}
		System.out.println("execution Completed...");
		
	}
}
