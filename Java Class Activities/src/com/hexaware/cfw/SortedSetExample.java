package com.hexaware.cfw;
 
import java.util.SortedSet;
import java.util.TreeSet;
 
public class SortedSetExample 
{
	public static void main(String[] args)
	{
	   SortedSet<Student> s = new TreeSet<>(new StudentIdComparator());
	   Student student1 = new Student(1,"Mayuresh");
	   Student student2 = new Student(10,"Mahendra");
	   Student student3 = new Student(78,"Firodiya");
	   s.add(student1);
	   s.add(student2);
	   s.add(student3);
	   System.out.println(s);

	}
}
