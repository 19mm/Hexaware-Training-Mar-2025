-- Task 1 (17 Mar 2025)

-- 1  
CREATE DATABASE SISDB;
USE SISDB;

-- 2
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

-- 3
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

select * from Students;	

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


-- Task 2 (18 Mar 2025)

-- 1
insert into students (first_nm, last_nm, dob, email, ph_nm) values ('John','Doe','1995-08-15','john.doe@example.com','1234567890');
select * from students;

-- 2
insert into enrollments(std_id, course_id, enrollment_date) values(11, 4, '2025-03-18');
select * from enrollments;

-- 3
update teacher set email='new.email@gmail.com' where teacher_id=1;
select * from teacher;

-- 4
delete from enrollments where std_id=1 and course_id=1;
select * from enrollments;

-- 5
update courses set teacher_id=1 where course_id=5;
select * from courses;

-- 6
DELETE FROM Enrollments WHERE std_id = 1; 
DELETE FROM Students WHERE std_id = 1; 

-- 7
update payments set amt=10000 where payment_id=1;
select * from payments;


-- Task 3 (19 Mar 2025)

-- 1
select s.std_id, s.first_nm, s.last_nm, sum(p.amt) as total_payment from students s
join payments p on s.std_id = p.std_id
where s.std_id = 5  
group by s.std_id, s.first_nm, s.last_nm;

-- 2
select c.course_id, c.course_nm, count(e.std_id) as student_count from courses c
join enrollments e on c.course_id = e.course_id
group by c.course_id, c.course_nm;

-- 3
select s.std_id, s.first_nm, s.last_nm from students s
left join enrollments e on s.std_id = e.std_id
where e.course_id is null;

-- 4
select s.first_nm, s.last_nm, c.course_nm from students s
join enrollments e on s.std_id = e.std_id 
join courses c on e.course_id = c.course_id;

-- 5
select t.first_nm, t.last_nm, c.course_nm from teacher t
join courses c on t.teacher_id = c.teacher_id;

-- 6
select s.first_nm, s.last_nm, e.enrollment_date
from students s
join enrollments e on s.std_id = e.std_id
join courses c on e.course_id = c.course_id
where c.course_id = 4;

-- 7
select s.first_nm, s.last_nm from students s
left join payments p on s.std_id = p.std_id
where p.payment_id is null;

-- 8
select c.course_nm from courses c
left join enrollments e on c.course_id = e.course_id where e.enrollment_id is null;

-- 9
select s.std_id, s.first_nm, s.last_nm, count(e.course_id) as course_count from students s
join enrollments e on s.std_id = e.std_id
group by s.std_id, s.first_nm, s.last_nm having count(e.course_id) > 1;

-- 10
select t.first_nm, t.last_nm from teacher t
left join courses c on t.teacher_id = c.teacher_id where c.course_id is null;


-- Task 4 (20 Mar 2025)

-- 1
select avg(student_count) as avg_students_per_course from 
(
    select course_id, count(std_id) as student_count
    from enrollments
    group by course_id
) 
as course_enrollment;

-- 2 
select first_nm, last_nm
from students
where std_id in (
    select std_id from payments where amt = (select max(amt) from payments)
);

-- 3
select course_nm from courses
where course_id in (
    select course_id from enrollments
    group by course_id
    having count(std_id) = (select max(student_count) from 
		(
            select course_id, count(std_id) as student_count from enrollments group by course_id
        )
        as course_counts
    )
);

-- 4
select first_nm, last_nm, (select sum(amt) from payments where std_id in 
		(
        select std_id from enrollments where course_id in 
			(
            select course_id from courses where teacher_id = t.teacher_id
			)
		)
	) as total_payments
from teacher t;

-- 5
select first_nm, last_nm from students where 
	(select count(distinct course_id) from enrollments where std_id = students.std_id) = (select count(*) from courses);

-- 6
select first_nm, last_nm from teacher where teacher_id not in (select distinct teacher_id from courses where teacher_id is not null);
 
-- 7
select avg(timestampdiff(year, dob, curdate())) as avg_age from students;

-- 8
select course_nm from courses where course_id not in (select distinct course_id from enrollments);

-- 9
select first_nm, last_nm, course_nm,(select sum(amt) from payments where std_id = s.std_id) as total_payments
from students s, courses c where c.course_id in (select course_id from enrollments where std_id = s.std_id);

-- 10
select first_nm, last_nm from students where std_id in 
(
    select std_id from payments
    group by std_id
    having count(payment_id) > 1
);

-- 11
select first_nm, last_nm,(select sum(amt) from payments where std_id = s.std_id) as total_payments from students s;

-- 12
select course_nm, (select count(*) from enrollments where course_id = c.course_id) as student_count from courses c;

-- 13
select avg(amt) as avg_payment from payments where std_id in (select std_id from students);