package com.hexaware.cfw;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) 
	{
		return Integer.compare(o1.getStid(), o2.getStid());
	}
}
