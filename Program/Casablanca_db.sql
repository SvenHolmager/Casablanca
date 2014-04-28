drop table activity_booking;
drop table instructor_activity_type;
drop table activity;
drop table activity_type;
drop table instructor;
drop table staying_guest;
drop table room_booking;
drop table paying_guest;
drop table room;
--drop table room_type;
--drop table payment_status;

create table paying_guest(
paying_guest_id int NOT NULL ,
first_name varchar(20) NOT NULL,
family_name varchar(20) NOT NULL,
address varchar(50)NOT NULL, 
country varchar(20)NOT NULL,
phone varchar(15) NOT NULL,
email varchar(25) NOT NULL, 
primary key(paying_guest_id)
);

create table room(
room_id int NOT NULL,
room_no int NOT NULL,
room_type varchar(20) NOT NULL,
max_residents int NOT NULL,
cost_per_night int NOT NULL,
primary key(room_id)
);

create table room_booking(
room_booking_id int NOT NULL,
paying_guest_id int NOT NULL,
room_id int NOT NULL,
check_in date NOT NULL,
check_out date NOT NULL,
travel_agency varchar(20) NULL,
payment_status varchar(10) NOT NULL,
primary key (room_booking_id),
foreign key (paying_guest_id) references paying_guest,
foreign key (room_id) references room
);

create table staying_guest(
staying_guest_id int NOT NULL, 
room_booking_id int NOT NULL,
first_name varchar(20) NOT NULL,
family_name varchar(20) NOT NULL,
primary key (staying_guest_id),
foreign key (room_booking_id) references room_booking
);

create table instructor(
instructor_id int,
full_name varchar(30) NOT NULL,
salary int  NOT NULL,
primary key (instructor_id)
);

create table activity_type(
activity_type_id int NOT NULL,
full_name varchar(30)  NOT NULL,
bookings_needed int NULL,
primary key (activity_type_id)
);

create table activity(
activity_id int NOT NULL,
activity_type_id int NOT NULL,
name varchar(30) NOT NULL,
primary key (activity_id),
foreign key (activity_type_id) references activity_type
);


create table instructor_activity_type(
instructor_id int NOT NULL,
activity_type_id int NOT NULL,
primary key (instructor_id, activity_type_id),
foreign key (instructor_id) references instructor,
foreign key (activity_type_id) references activity_type
);

create table activity_booking(
activity_booking_id int NOT NULL,
staying_guest_id int NOT NULL,
instructor_id int NULL,
activity_id int NOT NULL,
initiated char(1) NOT NULL,
thedate timestamp  NOT NULL,
primary key (activity_booking_id),
foreign key (staying_guest_id) references staying_guest,
foreign key (instructor_id) references instructor,
foreign key (activity_id) references activity
);


