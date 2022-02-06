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
-- To enter new dadta
insert into RentRV (FindRV, Price) values ('Class B', '5000');

CREATE TABLE BuyRV(
	BuyRVID int IDENTITY(1,1) primary key NOT NULL,
	FindRV varchar(max) NOT NULL,
	Price float NOT NULL,
);
-- To enter new data
insert into BuyRV (FindRV, Price) values ('Class C', 120000);

CREATE TABLE ContactUs(
	ContactID int IDENTITY(1,1) primary key NOT NULL,
	Email varchar(max) NOT NULL,
	Phone varchar(20),
	NewMessage varchar(max) NOT NULL,
);
-- To enter new data
insert

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
select * from BuyRV;
select * from RentRV;
select * from ContactUs;
select * from  PlanTrip;

-- To select tables with foreign key
select * from PlanTrip as PlT
inner join ContactUs as p on PlT.fk_ContactID = p.ContactID
inner join BuyRV as b on PlT.fk_BuyRVID = b.BuyRVID
inner join RentRV as r on PlT.fk_RentRVID = r.RentRVID;
-- If of the first conflict mode ...?
-- To select tables with foreign key to another call mode 
select P.Plan_tripID, P.Beginning_from, P.Arriving_at,
c.ContactID, c.Email as Email, c.Phone as Phone, c.NewMessage as NewMessage,
b.BuyRVID, b.FindRV as FindRV, b.Price as Price,
r.RentRVID, r.FindRV as Findrv, r.Price from PlanTrip as P
inner join ContactUs as c on P.fk_ContactID = c.ContactID
inner join BuyRV as b on P.fk_BuyRVID = b.BuyRVID
inner join RentRV as r on P.fk_RentRVID = r.RentRVID


--============================================
-- To delete a table
drop table BuyRV;
drop table RentRV;
drop table ContactUs;
drop table PlanTrip;