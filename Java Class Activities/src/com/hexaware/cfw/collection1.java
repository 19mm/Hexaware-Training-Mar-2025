package com.hexaware.cfw;

import java.util.LinkedList;
import java.util.List;
 
public class collection1 {
@SuppressWarnings("rawtypes")
public static void main(String[] args) {
		
		List<Comparable> l1 = new LinkedList<Comparable>();
		System.out.println("Operations on List 1");
		l1.add(Integer.valueOf(8));
		l1.add(Boolean.valueOf(true));
		l1.add(Double.valueOf(6.5));
		l1.add(null);
		l1.add(Integer.valueOf(70));
		l1.add(Double.valueOf(4.5));
		
		System.out.println(l1);
		System.out.println(l1.size());
		System.out.println(l1.get(2));
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		System.out.println(l1.contains(8));
		System.out.println(l1.contains(100));
		System.out.println(l1.isEmpty());
	    System.out.println(l1.remove(0));
		System.out.println(l1);
		
		System.out.println(l1.remove(Integer.valueOf(90)));
		System.out.println(l1);
		l1.add(1, Integer.valueOf(9));
		System.out.println(l1);
		
		l1.clear();
	    System.out.println(l1.isEmpty());
	    System.out.println(l1);
	    System.out.println("Operations on List 1 - Completed");
	    
		
		List<Comparable> l2 = new LinkedList<Comparable>();
		System.out.println("\n\nOperations on List 2");
		l2.add(true);
		l2.add(8);
		l2.add(8.9);
		l2.add("rk");
		
		System.out.println("Concate Items of List 1 with List 2");
		l1.addAll(l2);
		System.out.println(l1);
		
		System.out.println("Remove Items of List 2 from List 1");
		l1.removeAll(l2);
		
		System.out.println(l1);
		 System.out.println("Operations on List 2 - Completed");
	}
}
