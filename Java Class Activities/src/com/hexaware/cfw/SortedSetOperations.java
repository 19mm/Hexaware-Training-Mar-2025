package com.hexaware.cfw;
 
import java.util.SortedSet;
import java.util.TreeSet;
 
public class SortedSetOperations {
 
	public static void main(String[] args) {
		
		SortedSet<Integer> s = new TreeSet<>();
		for(int i=1;i<=10;i++)
		{
			s.add(i);
		}
		System.out.println(s.first());
		System.out.println(s.last());
		System.out.println(s.headSet(3));
		System.out.println(s.tailSet(3));
		System.out.println(s.subSet(1, 6));
	}
}