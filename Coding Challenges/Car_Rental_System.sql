-- DataBase Creation
create database Car_Rental_System;

use car_rental_system;

-- Database Schema Creation
create table Vehicle(VehicleId int primary key, Make varchar(50), Model varchar(50), Year int, Daily_Rate decimal(10,2), Status enum('avaiable','unavailable'),
Pass_Capacity int, Eng_Capacity int);

desc Vehicle;

create table Customer(CustomerId int primary key, F_name varchar(50), L_name varchar(50), email varchar(50) unique, ph_num varchar(50) unique);

desc Customer;

create table Lease(LeaseId int primary key, VehicleId int, CustomerId int, St_date date, End_date date, LeaseType enum('Daily', 'Monthly'), 
foreign key (VehicleId) references Vehicle(VehicleId), foreign key (CustomerId) references Customer(CustomerId));

desc Lease;

create table Payment(PaymentId int primary key, LeaseId int, Pay_Date date, amt decimal(10,2),
foreign key (LeaseId) references Lease(LeaseId));

desc payment;

-- Insertion of Values into Database
insert into Vehicle values
(1, 'Toyota', 'Camry', 2022, 50.00, 'avaiable', 4, 1450),
(2, 'Honda', 'Civic', 2023, 45.00, 'avaiable', 7, 1500),
(3, 'Ford', 'Focus', 2022, 48.00, 'unavailable', 4, 1400),
(4, 'Nissan', 'Altima', 2023, 52.00, 'avaiable', 7, 1200),
(5, 'Chevrolet', 'Malibu', 2022, 47.00, 'avaiable', 4, 1800),
(6, 'Hyundai', 'Sonata', 2023, 49.00, 'unavailable', 7, 1400),
(7, 'BMW', '3 Series', 2023, 60.00, 'avaiable', 7, 2499),
(8, 'Mercedes', 'C-Class', 2022, 58.00, 'avaiable', 8, 2599),
(9, 'Audi', 'A4', 2022, 55.00, 'unavailable', 4, 2500),
(10, 'Lexus', 'ES', 2023, 54.00, 'avaiable', 4, 2500);

select * from Vehicle;

insert into Customer values
(1, 'John', 'Doe', 'johndoe@example.com', '555-555-5555'),
(2, 'Jane', 'Smith', 'janesmith@example.com', '555-123-4567'),
(3, 'Robert', 'Johnson', 'robert@example.com', '555-789-1234'),
(4, 'Sarah', 'Brown', 'sarah@example.com', '555-456-7890'),
(5, 'David', 'Lee', 'david@example.com', '555-987-6543'),
(6, 'Laura', 'Hall', 'laura@example.com', '555-234-5678'),
(7, 'Michael', 'Davis', 'michael@example.com', '555-876-5432'),
(8, 'Emma', 'Wilson', 'emma@example.com', '555-432-1098'),
(9, 'William', 'Taylor', 'william@example.com', '555-321-6547'),
(10, 'Olivia', 'Adams', 'olivia@example.com', '555-765-4321');

select * from Customer;

insert into lease values
(1, 1, 1, '2023-01-01', '2023-01-05', 'Daily'),
(2, 2, 2, '2023-02-15', '2023-02-28', 'Monthly'),
(3, 3, 3, '2023-03-10', '2023-03-15', 'Daily'),
(4, 4, 4, '2023-04-20', '2023-04-30', 'Monthly'),
(5, 5, 5, '2023-05-05', '2023-05-10', 'Daily'),
(6, 4, 3, '2023-06-15', '2023-06-30', 'Monthly'),
(7, 7, 7, '2023-07-01', '2023-07-10', 'Daily'),
(8, 8, 8, '2023-08-12', '2023-08-15', 'Monthly'),
(9, 3, 3, '2023-09-07', '2023-09-10', 'Daily'),
(10, 10, 10, '2023-10-10', '2023-10-31', 'Monthly');

select * from lease;

insert into payment values
(1, 1, '2023-01-03', 200.00),
(2, 2, '2023-02-20', 1000.00),
(3, 3, '2023-03-12', 75.00),
(4, 4, '2023-04-25', 900.00),
(5, 5, '2023-05-07', 60.00),
(6, 6, '2023-06-18', 1200.00),
(7, 7, '2023-07-03', 40.00),
(8, 8, '2023-08-14', 1100.00),
(9, 9, '2023-09-09', 80.00),
(10, 10, '2023-10-25', 1500.00);

select * from payment;

-- 1. Updation of daily rate for a Mercedes car to 68.
update vehicle set daily_Rate=68 where VehicleId=8;
update Vehicle set Daily_Rate=68 where VehicleId=(Select VehicleId from(Select VehicleId from Vehicle where Make='Mercedes' Limit 1)as Temp);

-- 2. Deletion of a specific customer and all associated leases and payments.
delete from payment where LeaseId=(select LeaseId from Lease where CustomerId=1);
delete from Lease where CustomerId=1;
delete from customer where CustomerId=1;

-- 3. Rename the "Pay_Date" column in the Payment table to "transactionDate".
alter table payment rename column Pay_Date to transactionDate;

-- 4. Find a specific customer by email.
select * from customer where email='david@example.com';

--  5. Get active leases for a specific customer.
select * from lease where CustomerId=4 and End_Date >= '2023-05-10';
select * from lease where CustomerId=4 and End_Date >= curdate();

-- 6. All payments made by a customer with a specific phone number.
select p.* from payment p join lease l on p.LeaseId=l.LeaseId join customer c on l.CustomerId=c.CustomerId where c.ph_num='555-987-6543';
select * from payment where LeaseId=(Select LeaseId from Lease where CustomerId=(Select CustomerId from Customer where ph_num='555-432-1098'));

-- 7. Calculate the average daily_rate of all available cars.
select avg(Daily_Rate) as Average_Rate from Vehicle;

-- 8. Vehicle with the highest daily rate.
Select * from Vehicle order by Daily_Rate desc limit 1;

-- 9. Retrieve all Vehicles leased by a specific customer.
select v.* from Vehicle v join lease l on l.LeaseId=v.vehicleId where l.CustomerId=5;

-- 10. Details of the most recent lease. 
select * from lease order by End_Date desc limit 1;

-- 11. List of payments made in the year 2023.
select * from payment where year(transactionDate)=2023;

-- 12. Retrieve customers who have not made any payments.
select * from customer where CustomerId not in (select l.CustomerId from lease l join payment p where p.leaseId=L.leaseId);

-- 13. Retrieve Vehicle Details with Their Total_Payments.
select v.*, sum(p.amt) as Total_Payment from Vehicle v join lease l on v.VehicleId=l.VehicleId join payment p on l.LeaseId=p.PaymentId group by v.VehicleId;

-- 14 Calculate Total Payments for Each Customer.
select c.CustomerID, c.F_name, c.L_name, SUM(p.amt) AS totalPayments from Customer c join Lease l on c.CustomerId = l.CustomerId join Payment p on l.LeaseId = p.LeaseId
group by c.CustomerId;

-- 15.List Vehicle Details for Each Lease.
select l.leaseId, v.* from lease l join vehicle v on l.VehicleId=v.VehicleId;

-- 16. Retrieve Details of Active Leases with Customer and Vehicle Information.
select l.*, c.*, v.* from lease l join customer c on l.customerId=c.customerId join vehicle v on v.vehicleId=l.vehicleId where end_Date>='2023-04-30';

-- 17. Customer Who Has Spent the Most on Leases.
select c.*,sum(p.amt) as Total_Spent from customer c join lease l on c.customerId=l.customerId join payment p on l.leaseId=p.leaseId group by c.customerId
 order by Total_Spent desc limit 1;

-- 18 List of All Vehicles and Their Current Lease Information.
select v.*, l.* from vehicle v left join lease l on v.vehicleId=l.vehicleId where l.End_Date>='2023-05-10';
