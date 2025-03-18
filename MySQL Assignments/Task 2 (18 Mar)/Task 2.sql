use SISDB;
show tables;

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
DELETE FROM Enrollments
WHERE std_id = 1; 
DELETE FROM Students
WHERE std_id = 1; 

-- 7
update payments set amt=10000 where payment_id=1;
select * from payments;