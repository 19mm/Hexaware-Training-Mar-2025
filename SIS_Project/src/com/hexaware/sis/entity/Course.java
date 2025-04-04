package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private String courseCode;
    private Teacher instructor; // Assigned teacher
    private int credits;
    private List<Enrollment> enrollments; // For Task 5

    public Course(int courseId, String courseName, String courseCode, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.enrollments = new ArrayList<>();
    }

    // Getters and setters
    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }
    public Teacher getInstructor() { return instructor; }
    public List<Enrollment> getEnrollments() { return enrollments; }

    public void assignTeacher(Teacher teacher) {
        this.instructor = teacher;
        teacher.addAssignedCourse(this);
    }

    public void updateCourseInfo(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credits: " + credits);
        if(instructor != null)
            System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
        else
            System.out.println("Instructor: Not Assigned");
    }
}
