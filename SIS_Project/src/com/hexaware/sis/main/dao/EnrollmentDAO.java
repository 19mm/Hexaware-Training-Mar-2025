package com.hexaware.sis.main.dao;

import com.hexaware.sis.entity.Enrollment;
import com.hexaware.sis.exception.InvalidEnrollmentDataException;
import java.util.*;

public class EnrollmentDAO {
    // Simulated database using a List
    private static List<Enrollment> enrollments = new ArrayList<>();
    
    // Create: Adds a new enrollment to the database
    public void addEnrollment(Enrollment enrollment) {
        if(enrollment == null) {
            throw new InvalidEnrollmentDataException("Enrollment cannot be null.");
        }
        enrollments.add(enrollment);
        System.out.println("Enrollment added: Student ID " + enrollment.getStudent().getStudentId() +
                           " in Course " + enrollment.getCourse().getCourseName());
    }
    
    // Read: Retrieves enrollments by course ID
    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        List<Enrollment> result = new ArrayList<>();
        for(Enrollment e : enrollments) {
            if(e.getCourse().getCourseId() == courseId)
                result.add(e);
        }
        return result;
    }
    
    // Read: Retrieves an enrollment by its ID
    public Enrollment getEnrollmentById(int enrollmentId) {
        for(Enrollment e : enrollments) {
            if(e.getEnrollmentId() == enrollmentId)
                return e;
        }
        throw new InvalidEnrollmentDataException("Enrollment not found with ID: " + enrollmentId);
    }
    
    // Update: Updates an existing enrollment
    public void updateEnrollment(Enrollment enrollment) {
        boolean found = false;
        for (int i = 0; i < enrollments.size(); i++) {
            if(enrollments.get(i).getEnrollmentId() == enrollment.getEnrollmentId()) {
                enrollments.set(i, enrollment);
                found = true;
                System.out.println("Enrollment updated with ID: " + enrollment.getEnrollmentId());
                break;
            }
        }
        if(!found) {
            throw new InvalidEnrollmentDataException("Enrollment not found with ID: " + enrollment.getEnrollmentId());
        }
    }
    
    // Delete: Removes an enrollment by its ID
    public void deleteEnrollment(int enrollmentId) {
        boolean removed = enrollments.removeIf(e -> e.getEnrollmentId() == enrollmentId);
        if(removed) {
            System.out.println("Enrollment removed with ID: " + enrollmentId);
        } else {
            throw new InvalidEnrollmentDataException("Enrollment not found with ID: " + enrollmentId);
        }
    }
    
    // Retrieve All: Returns a list of all enrollments
    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
