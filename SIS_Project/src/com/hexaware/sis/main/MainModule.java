package com.hexaware.sis.main;

import com.hexaware.sis.entity.*;
import com.hexaware.sis.exception.*;
import com.hexaware.sis.main.dao.*;
import com.hexaware.sis.main.util.DBPropertyUtil;
import com.hexaware.sis.main.util.DBConnUtil;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class MainModule {

    // DAO objects (simulating DB operations)
    static StudentDAO studentDAO = new StudentDAO();
    static CourseDAO courseDAO = new CourseDAO();
    static EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    static TeacherDAO teacherDAO = new TeacherDAO();
    static PaymentDAO paymentDAO = new PaymentDAO();

    public static void main(String[] args) {
        // For demonstration, we skip actual DB connection code.
        String connStr = DBPropertyUtil.getConnectionString("\\dbconfig.properties");
        Connection conn = DBConnUtil.getConnection(connStr);
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n=== Student Information System Menu ===");
            System.out.println("1. Add New Student (Task 2.1 / Task 8)");
            System.out.println("2. Enroll Student in a Course (Task 2.2 / Task 8)");
            System.out.println("3. Update Teacher Email (Task 2.3)");
            System.out.println("4. Delete Enrollment Record (Task 2.4)");
            System.out.println("5. Assign Teacher to Course (Task 2.5 / Task 9)");
            System.out.println("6. Delete Student and Their Enrollments (Task 2.6)");
            System.out.println("7. Update Payment Amount (Task 2.7)");
            System.out.println("8. Generate Total Payments for a Student (Task 3.1 & Task 4.11)");
            System.out.println("9. Generate Enrollment Report (Task 11)");
            System.out.println("10. Record Payment for a Student (Task 10)");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch(choice) {
                    case 1:
                        addNewStudent(scanner);
                        break;
                    case 2:
                        enrollStudentInCourse(scanner);
                        break;
                    case 3:
                        updateTeacherEmail(scanner);
                        break;
                    case 4:
                        deleteEnrollment(scanner);
                        break;
                    case 5:
                        assignTeacherToCourse(scanner);
                        break;
                    case 6:
                        deleteStudentAndEnrollments(scanner);
                        break;
                    case 7:
                        updatePaymentAmount(scanner);
                        break;
                    case 8:
                        generateTotalPaymentsForStudent(scanner);
                        break;
                    case 9:
                        generateEnrollmentReport(scanner);
                        break;
                    case 10:
                        recordPaymentForStudent(scanner);
                        break;
                    case 11:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while(choice != 11);

        scanner.close();
    }

    // Task 2.1 / Task 8: Add New Student (e.g., John Doe)
    private static void addNewStudent(Scanner scanner) {
        System.out.println("Enter Student Details:");
        System.out.print("Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("First Name: ");
        String fName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lName = scanner.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();
        Student student = new Student(id, fName, lName, dob, email, phone);
        studentDAO.addStudent(student);
    }

    // Task 2.2 / Task 8: Enroll a student in a course
    private static void enrollStudentInCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        Student student = studentDAO.getStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        // For simplicity, assume course exists. In practice, retrieve via CourseDAO.
        Course course = courseDAO.getCourseByCode("CODE" + courseId); // Dummy retrieval
        if (course == null) {
            // Create a dummy course if not exists for demo
            course = new Course(courseId, "Course" + courseId, "CODE" + courseId, 3);
            courseDAO.addCourse(course);
        }
        System.out.print("Enter Enrollment Date (YYYY-MM-DD): ");
        LocalDate enrollDate = LocalDate.parse(scanner.nextLine());
        student.enrollInCourse(course, enrollDate);
        // Save enrollment in DAO
        Enrollment enrollment = new Enrollment(1, student, course, enrollDate); // enrollmentId simulated
        enrollmentDAO.addEnrollment(enrollment);
    }

    // Task 2.3: Update Teacher Email
    private static void updateTeacherEmail(Scanner scanner) {
        System.out.print("Enter Teacher ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = teacherDAO.getTeacher(teacherId);
        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher not found with ID: " + teacherId);
        }
        System.out.print("Enter new Email: ");
        String newEmail = scanner.nextLine();
        teacher.updateTeacherInfo(teacher.getFirstName(), teacher.getLastName(), newEmail);
        System.out.println("Teacher email updated.");
    }

    // Task 2.4: Delete Enrollment Record
    private static void deleteEnrollment(Scanner scanner) {
        System.out.print("Enter Enrollment ID to delete: ");
        int enrollmentId = scanner.nextInt();
        scanner.nextLine();
        // For simplicity, simulate deletion by printing (in practice, remove from DB/DAO list)\n
        System.out.println("Enrollment with ID " + enrollmentId + " deleted (simulation).");
    }

    // Task 2.5 / Task 9: Assign Teacher to Course
    private static void assignTeacherToCourse(Scanner scanner) {
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = courseDAO.getCourseByCode(courseCode);
        if (course == null) {
            throw new CourseNotFoundException("Course not found with code: " + courseCode);
        }
        System.out.print("Enter Teacher ID to assign: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = teacherDAO.getTeacher(teacherId);
        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher not found with ID: " + teacherId);
        }
        course.assignTeacher(teacher);
        System.out.println("Teacher assigned to course successfully.");
    }

    // Task 2.6: Delete a Student and all their Enrollments
    private static void deleteStudentAndEnrollments(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        studentDAO.deleteStudent(studentId);
        // In practice, also remove associated enrollments from EnrollmentDAO/DB.
        System.out.println("Student and associated enrollments deleted (simulation).");
    }

    // Task 2.7: Update Payment Amount for a Payment Record
    private static void updatePaymentAmount(Scanner scanner) {
        System.out.print("Enter Payment ID to update: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        // In practice, retrieve payment record and update it.
        System.out.println("Payment ID " + paymentId + " updated with new amount: $" + amount + " (simulation).");
    }

    // Task 3.1 / Task 4.11: Generate Total Payments for a Student
    private static void generateTotalPaymentsForStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        Student student = studentDAO.getStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
        double total = student.getPaymentHistory().stream().mapToDouble(Payment::getAmount).sum();
        System.out.println("Total payments made by Student ID " + studentId + " is: $" + total);
    }

    // Task 11: Generate Enrollment Report for a Course
    private static void generateEnrollmentReport(Scanner scanner) {
        System.out.print("Enter Course ID for Enrollment Report: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();
        List<Enrollment> enrollments = enrollmentDAO.getEnrollmentsByCourse(courseId);
        System.out.println("Enrollment Report for Course ID " + courseId + ":");
        for(Enrollment e : enrollments) {
            System.out.println("Enrollment ID: " + e.getEnrollmentId() + ", Student: " +
                e.getStudent().getFirstName() + " " + e.getStudent().getLastName() +
                ", Date: " + e.getEnrollmentDate());
        }
    }

    // Task 10: Record a Payment for a Student (e.g., Jane Johnson's payment)
    private static void recordPaymentForStudent(Scanner scanner) {
        System.out.print("Enter Student ID for Payment: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        Student student = studentDAO.getStudent(studentId);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }
        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
        LocalDate paymentDate = LocalDate.parse(scanner.nextLine());
        student.makePayment(amount, paymentDate);
        // Save payment via DAO
        Payment payment = new Payment(student.getPaymentHistory().size(), student, amount, paymentDate);
        paymentDAO.addPayment(payment);
    }
}
