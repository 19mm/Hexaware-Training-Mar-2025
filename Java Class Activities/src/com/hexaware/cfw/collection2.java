package com.hexaware.cfw;

import java.util.ArrayList;
import java.util.List;

public class collection2 {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		for(int i=1;i<=10;i++)
		{
			l.add(i);
		}
		System.out.println("Contents of List are: "+l);
		System.out.println("\nEven Elements of List are: ");
		for(Integer i:l )
		{
			if(i%2==0)
				System.out.print(i+" ");
		}
	}
}
