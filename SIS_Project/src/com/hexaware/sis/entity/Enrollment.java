package com.hexaware.sis.entity;

import java.time.LocalDate;

public class Enrollment {
    private int enrollmentId;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;

    public Enrollment(int enrollmentId, Student student, Course course, LocalDate enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters
    public int getEnrollmentId() 
    {
    	return enrollmentId; 
    }
    
    public Student getStudent() 
    {
    	return student; 
    }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
}
