package com.hexaware.exception;

public class exception3 {
	public void checkProduct(int Weight)
	{
		if(Weight>100)
			System.out.println("Product is Valid");
		else {
			try {
			throw new InvalidProductException("Product Weight must be greater than 100kgs");
			}
			catch(InvalidProductException ip)
			{
				System.out.println(ip.getMessage());
			}
		}
	}
}
