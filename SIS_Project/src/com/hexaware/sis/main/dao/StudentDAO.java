package com.hexaware.sis.main.dao;

import com.hexaware.sis.entity.Student;
import com.hexaware.sis.exception.StudentNotFoundException;
import java.util.*;

public class StudentDAO {
    // Simulated database using a HashMap (studentId -> Student)
    private static Map<Integer, Student> studentDB = new HashMap<>();
    
    // Create: Adds a new student to the database
    public void addStudent(Student student) {
        if(studentDB.containsKey(student.getStudentId())) {
            System.out.println("Student already exists with ID: " + student.getStudentId());
            return;
        }
        studentDB.put(student.getStudentId(), student);
        System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
    }
    
    // Read: Retrieves a student by their ID
    public Student getStudent(int studentId) {
        Student student = studentDB.get(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
        return student;
    }
    
    // Update: Updates an existing student's information
    public void updateStudent(Student student) {
        if (!studentDB.containsKey(student.getStudentId())) {
            throw new StudentNotFoundException("Cannot update. Student not found with ID: " + student.getStudentId());
        }
        studentDB.put(student.getStudentId(), student);
        System.out.println("Student updated: " + student.getFirstName() + " " + student.getLastName());
    }
    
    // Delete: Removes a student from the database
    public void deleteStudent(int studentId) {
        if (!studentDB.containsKey(studentId)) {
            throw new StudentNotFoundException("Cannot delete. Student not found with ID: " + studentId);
        }
        studentDB.remove(studentId);
        System.out.println("Student removed with ID: " + studentId);
    }
    
    // Retrieve All: Returns a list of all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDB.values());
    }
}
