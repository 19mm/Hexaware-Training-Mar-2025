create database Insurance_Management_System;

use Insurance_Management_System;

-- create user table
create table user (
    userid int primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    role varchar(20) not null
);

desc user;

-- create policy table
create table policy (
    policyid int primary key,
    policynumber varchar(50) not null,
    policytype varchar(50) not null,
    premium double not null
);

desc user;

-- create client table
create table client (
    clientid int primary key,
    clientname varchar(100) not null,
    contactinfo varchar(100),
    policyid int,
    foreign key (policyid) references policy(policyid)
);

desc client;

-- create claim table
create table claim (
    claimid int primary key,
    claimnumber varchar(50) not null,
    datefiled date,
    claimamount double,
    status varchar(20),
    policyid int,
    clientid int,
    foreign key (policyid) references policy(policyid),
    foreign key (clientid) references client(clientid)
);

desc claim;

-- create payment table
create table claimpayment (
    paymentid int primary key,
    paymentdate date,
    paymentamount double,
    clientid int,
    foreign key (clientid) references client(clientid)
);

desc claimpayment;

show tables;

-- dummy data for user table
insert into user (userid, username, password, role) values
(1, 'amit123', 'pass123', 'admin'),
(2, 'sunita45', 'secure45', 'agent'),
(3, 'vikram89', 'vpass89', 'agent'),
(4, 'priya77', 'ppass77', 'client');

select * from user;

-- dummy data for policy table
insert into policy (policyid, policynumber, policytype, premium) values
(101, 'pl1001', 'life insurance', 15000.00),
(102, 'pl1002', 'health insurance', 12000.00),
(103, 'pl1003', 'vehicle insurance', 8000.00),
(104, 'pl1004', 'home insurance', 10000.00),
(105, 'pl1005', 'travel insurance', 5000.00);

select * from policy;

-- dummy data for client table
insert into client (clientid, clientname, contactinfo, policyid) values
(201, 'rajesh kumar', 'rajesh.kumar@email.com, 9876543210', 101),
(202, 'pooja sharma', 'pooja.sharma@email.com, 8765432109', 102),
(203, 'suresh verma', 'suresh.verma@email.com, 7654321098', 103),
(204, 'anjali patel', 'anjali.patel@email.com, 6543210987', 104),
(205, 'dev singh', 'dev.singh@email.com, 5432109876', 101),
(206, 'meena gupta', 'meena.gupta@email.com, 9988776655', 105);

select * from client;

-- dummy data for claim table
insert into claim (claimid, claimnumber, datefiled, claimamount, status, policyid, clientid) values
(301, 'cl2001', '2025-03-15', 50000.00, 'approved', 102, 202),
(302, 'cl2002', '2025-03-20', 12000.00, 'pending', 103, 203),
(303, 'cl2003', '2025-04-01', 25000.00, 'rejected', 101, 201),
(304, 'cl2004', '2025-04-05', 8000.00, 'approved', 104, 204);

select * from claim;

-- dummy data for claimpayment table
insert into claimpayment (paymentid, paymentdate, paymentamount, clientid) values
(401, '2025-03-25', 50000.00, 202),
(402, '2025-04-10', 8000.00, 204);

select * from claimpayment;