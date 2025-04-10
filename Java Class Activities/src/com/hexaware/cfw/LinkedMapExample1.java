package com.hexaware.cfw;
 
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
 
@SuppressWarnings("unused")
public class LinkedMapExample1 {
	
	public static void main(String[] args) {
		
		Map<Integer,String>  map = new LinkedHashMap<>();
		
		map.put(1, "Mayuresh");
		map.put(2, "Mahendra");
		map.put(3, "Kalpna");
		map.put(4, "Firodiya");
		
		for(Map.Entry<Integer,String> me : map.entrySet())
		{
			if(me.getValue().startsWith("K"))
			{
				System.out.println("Element found at position "+me.getKey()+" and its value is " + me.getValue());
			}
		}
		
	}
	
}
 