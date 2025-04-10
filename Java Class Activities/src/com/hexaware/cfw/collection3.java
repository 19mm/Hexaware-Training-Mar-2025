package com.hexaware.cfw;

import java.util.ArrayList;
import java.util.List;

public class collection3 {
		public static void main(String[] args) {
	 
			List<Student> l = new ArrayList<>();
	 
			
			Student Mayuresh = new Student(1, "Mayuresh");
			Student Mahendra = new Student(2, "Mahendra");
			Student Kalpna = new Student(3, "Kalpna");
	 
			l.add(Mayuresh);
			l.add(Mahendra);
			l.add(Kalpna);
	 
			System.out.println("Contents of List are: "); 
			for(Student st:l)
			{
				System.out.println(st);
			} 
		}
}