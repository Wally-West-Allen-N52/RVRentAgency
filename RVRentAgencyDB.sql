-- Create database
create database RVRentAgencyDB;
-- Stsrt DB
USE RVRentAgencyDB

--============================================================
-- Create the tables--

CREATE TABLE RentRV(
	RentRVID int IDENTITY(1,1) primary key NOT NULL,
	FindRV varchar(max) NOT NULL,
	Price float NOT NULL
	);

CREATE TABLE BuyRV(
	BuyRVID int IDENTITY(1,1) primary key NOT NULL,
	FindRV varchar(max) NOT NULL,
	Price float NOT NULL,
);


CREATE TABLE ContactUs(
	ContactID int IDENTITY(1,1) primary key NOT NULL,
	Email varchar(max) NOT NULL,
	Phone varchar(15),
	NewMessage varchar(max) NOT NULL,
);

CREATE TABLE PlanTrip(
	Plan_tripID int IDENTITY(1,1) primary key NOT NULL,
	Beginning_from varchar(max) NOT NULL,
	Arriving_at varchar(max) NOT NULL,
	fk_BuyRVID int NULL,
	fk_RentRVID int NULL,
	fk_ContactID int null,
);

--============================================================

-- Modify the tables
alter table PlanTrip add constraint FK_RentRVID
foreign key (fk_RentRVID)
references RentRV (RentRVID)
on delete cascade;

alter table PlanTrip add constraint FK_BuyRVID
foreign key (fk_BuyRVID)
references BuyRV (BuyRVID)
on delete cascade;

alter table PlanTrip add constraint FK_ContactID
foreign key (fk_ContactID)
references ContactUs (ContactID)
on delete cascade;
--===========================================
-- To select a trable
select * from RentRV;
select * from BuyRV;
select * from ContactUs;
select * from  PlanTrip;

--============================================
-- To delete a table
drop table BuyRV;
drop table RentRV;
drop table ContactUs;
drop table PlanTrip;