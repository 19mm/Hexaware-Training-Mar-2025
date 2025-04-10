package com.hexaware.cfw;
 
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
 
@SuppressWarnings("unused")
public class LinkedMapExample {
	
	public static void main(String[] args) {
		
		Map<Integer,String>  map = new LinkedHashMap<>();
		map.put(1, "Mayuresh");
		map.put(2, "Mahendra");
		map.put(3, "Kalpna");
		map.put(4, "Firodiya");
		int i=0;
		for(Map.Entry<Integer,String> me : map.entrySet())
		{
			i++;
			System.out.println("Content of "+i+" position element is: "+me.getKey() + " - " + me.getValue());
		}
		
	}
}