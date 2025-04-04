package com.hexaware.sis.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.sis.exception.DuplicateEnrollmentException;
import com.hexaware.sis.exception.PaymentValidationException;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private List<Enrollment> enrollments;  // Collection to store enrollments
    private List<Payment> payments;          // Collection to store payment records

    // Constructor to initialize all attributes and collections
    public Student(int studentId, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.enrollments = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    // Getters
    public int getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    public List<Payment> getPaymentHistory() { return payments; }

    // Method to enroll a student in a course (throws exception if already enrolled)
    public void enrollInCourse(Course course, LocalDate enrollmentDate) throws DuplicateEnrollmentException {
        // Check for duplicate enrollment
        for (Enrollment e : enrollments) {
            if (e.getCourse().getCourseId() == course.getCourseId()) {
                throw new DuplicateEnrollmentException("Student already enrolled in course: " + course.getCourseName());
            }
        }
        // Create and add the enrollment to both student and course collections
        Enrollment enrollment = new Enrollment(enrollments.size() + 1, this, course, enrollmentDate);
        enrollments.add(enrollment);
        course.getEnrollments().add(enrollment);
        System.out.println(firstName + " " + lastName + " enrolled in course " + course.getCourseName());
    }

    // Method to update student information
    public void updateStudentInfo(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Method to record a payment
    public void makePayment(double amount, LocalDate paymentDate) {
        if (amount <= 0) {
            throw new PaymentValidationException("Invalid payment amount: " + amount);
        }
        Payment payment = new Payment(payments.size() + 1, this, amount, paymentDate);
        payments.add(payment);
        System.out.println("Payment of $" + amount + " made by " + firstName + " " + lastName);
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("DOB: " + dateOfBirth);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }
}
