package com.hexaware.cfw;
 
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
 
public class HashMapExample {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Map map = new LinkedHashMap();
		
		map.put(1, "Mayuresh");
		
		map.put(2, "Mahendra");
		
		map.put(3, "Kalpna");
		map.put("Firodiya", 4);
		
		map.put(null, null);
		
		Set s = map.entrySet();
		System.out.println("Contents of Map are: ");
		for(Object o: s)
		{
			System.out.println(o);
		}
	}
	
}