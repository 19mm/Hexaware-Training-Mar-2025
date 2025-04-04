package com.hexaware.sis.main.dao;

import com.hexaware.sis.entity.Course;
import com.hexaware.sis.exception.CourseNotFoundException;
import java.util.*;

public class CourseDAO {
    // Simulated database using a HashMap (courseId -> Course)
    private static Map<Integer, Course> courseDB = new HashMap<>();
    
    // Create: Adds a new course to the database
    public void addCourse(Course course) {
        if(courseDB.containsKey(course.getCourseId())) {
            System.out.println("Course already exists with ID: " + course.getCourseId());
            return;
        }
        courseDB.put(course.getCourseId(), course);
        System.out.println("Course added: " + course.getCourseName());
    }
    
    // Read: Retrieves a course by its code
    public Course getCourseByCode(String courseCode) {
        for(Course c : courseDB.values()){
            if(c.getCourseCode().equalsIgnoreCase(courseCode))
                return c;
        }
        throw new CourseNotFoundException("Course not found with code: " + courseCode);
    }
    
    // Read: Retrieves a course by its ID
    public Course getCourseById(int courseId) {
        Course course = courseDB.get(courseId);
        if (course == null) {
            throw new CourseNotFoundException("Course not found with ID: " + courseId);
        }
        return course;
    }
    
    // Update: Updates an existing course's information
    public void updateCourse(Course course) {
        if (!courseDB.containsKey(course.getCourseId())) {
            throw new CourseNotFoundException("Cannot update. Course not found with ID: " + course.getCourseId());
        }
        courseDB.put(course.getCourseId(), course);
        System.out.println("Course updated: " + course.getCourseName());
    }
    
    // Delete: Removes a course from the database
    public void deleteCourse(int courseId) {
        if (!courseDB.containsKey(courseId)) {
            throw new CourseNotFoundException("Cannot delete. Course not found with ID: " + courseId);
        }
        courseDB.remove(courseId);
        System.out.println("Course removed with ID: " + courseId);
    }
    
    // Retrieve All: Returns a list of all courses
    public List<Course> getAllCourses() {
        return new ArrayList<>(courseDB.values());
    }
}
