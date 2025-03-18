CREATE DATABASE SISDB;
USE SISDB;

CREATE TABLE Students (
    std_id INT AUTO_INCREMENT PRIMARY KEY,
    first_nm VARCHAR(50) NOT NULL,
    last_nm VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
    ph_nm VARCHAR(15) UNIQUE NOT NULL
);

SHOW TABLES;

CREATE TABLE Teacher (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    first_nm VARCHAR(50) NOT NULL,
    last_nm VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_nm VARCHAR(100) NOT NULL,
    credits INT NOT NULL CHECK (credits > 0),
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id) ON DELETE SET NULL
);

CREATE TABLE Enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    std_id INT,
    course_id INT,
    enrollment_date DATE NOT NULL,
    FOREIGN KEY (std_id) REFERENCES Students(std_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) ON DELETE CASCADE
);

CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    std_id INT,
    amt DECIMAL(10,2) NOT NULL CHECK (amt > 0),
    payment_date DATE NOT NULL,
    FOREIGN KEY (std_id) REFERENCES Students(std_id) ON DELETE CASCADE
);

SHOW TABLES;

INSERT INTO Students (first_nm, last_nm, dob, email, ph_nm) VALUES
('Mayuresh', 'Firodiya', '2003-04-19','mayuresh.firodiya@gmail.com', '750375393'),
('Mahendra', 'Firodiya', '1970-09-01', 'mahendra.firodiya@gmail.com','9422017992'), 
('Rahul', 'Sharma', '2003-05-14', 'rahul.sharma@gmail.com', '9876543210'),
('Sneha', 'Deshmukh', '2003-03-05', 'sneha.deshmukh@gmail.com', '8446639223'),
('Aakash', 'Jadhav', '2000-03-18', 'aakash.jadhav@gmail.com', '9876543212'),
('Kiran', 'Kumar', '2002-10-10', 'kiran.kumar@gmail.com', '9876543213'),
('Aditya', 'Verma', '2003-12-30', 'aditya.verma@gmail.com', '9876543214'),
('Vivek', 'Chauhan', '2003-11-05', 'vivek.chauhan@gmail.com', '9876543216'),
('Meera', 'Joshi', '2002-06-20', 'meera.joshi@gmail.com', '9876543217'),
('Anjali', 'Naik', '2003-04-11', 'anjali.naik@gmail.com', '9876543219');

SELECT * FROM Students;

INSERT INTO Teacher (first_nm, last_nm, email) VALUES
('Dr. Asha', 'Kulkarni', 'asha.kulkarni@mituniversity.edu.in'),
('Dr. Ravi', 'Patil', 'ravi.patil@mituniversity.edu.in'),
('Prof. Megha', 'Shinde', 'megha.shinde@mituniversity.edu.in');

SELECT * FROM Teacher;

INSERT INTO Courses (course_nm, credits, teacher_id) VALUES
('Data Structues and Algorithms', 4, 1),
('DBMS', 3, 2),
('AI & ML', 3, 2),
('Cyber Forensics', 4, 3),
('Web Design & Development', 2, NULL);

SELECT * FROM Courses;

INSERT INTO Enrollments (std_id, course_id, enrollment_date) VALUES
(1, 1, '2025-01-10'),
(2, 2, '2025-01-12'),
(3, 3, '2025-01-14'),
(4, 4, '2025-01-16'),
(5, 1, '2025-01-18'),
(6, 2, '2025-01-20'),
(7, 3, '2025-01-22'),
(8, 4, '2025-01-24'),
(9, 1, '2025-01-26'),
(10, 2, '2025-01-28');

SELECT * FROM Enrollments;

INSERT INTO Payments (std_id, amt, payment_date) VALUES
(1, 5000.00, '2025-02-01'),
(2, 4500.00, '2025-02-02'),
(3, 4800.00, '2025-02-03'),
(4, 5200.00, '2025-02-04'),
(5, 5000.00, '2025-02-05'),
(6, 4500.00, '2025-02-06'),
(7, 4800.00, '2025-02-07'),
(8, 5200.00, '2025-02-08'),
(9, 5000.00, '2025-02-09'),
(10, 4500.00, '2025-02-10');

SELECT * FROM Enrollments;