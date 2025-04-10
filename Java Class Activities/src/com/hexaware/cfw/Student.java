package com.hexaware.cfw;

public class Student {
	private int st_id;
	private String st_name;
	
	public int getStid() {
		return st_id;
	}
	public void setStid(int stid) {
		this.st_id = stid;
	}
	public String getStname() {
		return st_name;
	}
	public void setStname(String stname) {
		this.st_name = stname;
	}
	public Student(int stid, String stname) {
		super();
		this.st_id = stid;
		this.st_name = stname;
	}
	
	public Student()
	{
		
	}
	
	@Override
	public String toString()
	{
		return st_id + " " + st_name;
	}
	
	public int compareTo(Student o) 
	{
		return Integer.compare(this.getStid(), o.getStid());
	}
	
}
