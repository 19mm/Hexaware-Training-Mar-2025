package com.hexaware.sis.main.dao;

import com.hexaware.sis.entity.Teacher;
import com.hexaware.sis.exception.TeacherNotFoundException;
import java.util.*;

public class TeacherDAO {
    // Simulated database using a HashMap (teacherId -> Teacher)
    private static Map<Integer, Teacher> teacherDB = new HashMap<>();
    
    // Create: Adds a new teacher to the database
    public void addTeacher(Teacher teacher) {
        if(teacherDB.containsKey(teacher.getTeacherId())) {
            System.out.println("Teacher already exists with ID: " + teacher.getTeacherId());
            return;
        }
        teacherDB.put(teacher.getTeacherId(), teacher);
        System.out.println("Teacher added: " + teacher.getFirstName() + " " + teacher.getLastName());
    }
    
    // Read: Retrieves a teacher by their ID
    public Teacher getTeacher(int teacherId) {
        Teacher teacher = teacherDB.get(teacherId);
        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher not found with ID: " + teacherId);
        }
        return teacher;
    }
    
    // Update: Updates an existing teacher's information
    public void updateTeacher(Teacher teacher) {
        if (!teacherDB.containsKey(teacher.getTeacherId())) {
            throw new TeacherNotFoundException("Cannot update. Teacher not found with ID: " + teacher.getTeacherId());
        }
        teacherDB.put(teacher.getTeacherId(), teacher);
        System.out.println("Teacher updated: " + teacher.getFirstName() + " " + teacher.getLastName());
    }
    
    // Delete: Removes a teacher from the database
    public void deleteTeacher(int teacherId) {
        if (!teacherDB.containsKey(teacherId)) {
            throw new TeacherNotFoundException("Cannot delete. Teacher not found with ID: " + teacherId);
        }
        teacherDB.remove(teacherId);
        System.out.println("Teacher removed with ID: " + teacherId);
    }
    
    // Retrieve All: Returns a list of all teachers
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teacherDB.values());
    }
}
