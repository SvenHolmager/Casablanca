drop table staying_guest;
drop table room_booking;
drop table room;
drop table payment_status;
drop table room_type;
drop table paying_guest;

create table paying_guest(
paying_guest_id int ,
first_name varchar(20) NOT NULL,
family_name varchar(20) NOT NULL,
address varchar(50)NOT NULL, 
country varchar(20)NOT NULL,
phone varchar(15) NOT NULL,
email varchar(25) NOT NULL, 
primary key(paying_guest_id)
);

create table room(
room_id int,
room_type_id int,
primary key(room_id)
);

create table payment_status(
payment_id int,
payment_name varchar(20),
primary key (payment_id)
);

create table room_booking(
room_booking_id int,
paying_guest_id int,
room_id int,
--paymentstatusid
payment_status_id int,
check_in date,
check_out date,
travel_agency varchar(20),
--constraint room_booking_pk primary key (paying_guest_id,room_id),
primary key (room_booking_id),
foreign key (paying_guest_id) references paying_guest,
foreign key (room_id) references room
);

create table staying_guest(
staying_guest_id int, 
first_name varchar(20),
family_name varchar(20),
room_booking_id int,
primary key (staying_guest_id),
foreign key (room_booking_id) references room_booking
);

create table room_type(
type_id int,
name varchar(10),
max_residents int,
cost_per_night int,
primary key (type_id)
);