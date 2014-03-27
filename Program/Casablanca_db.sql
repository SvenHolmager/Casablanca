drop table staying_guest;
drop table room_booking;
drop table room;
drop table paymentstatus;
drop table room_type;
drop table paying_guest;

create table paying_guest(
paying_guest_id int,
reservation_id int,
first_name varchar(20),
family_name varchar(20),
adress varchar(50),
country varchar(20),
phone varchar(15),
email varchar(25),
primary key(paying_guest_id)
);

create table room(
room_id int,
roomtypeid int,
primary key(room_id)
);

create table paymentstatus(
payment_id int,
payment_name varchar(20),
primary key (payment_id)
);

create table room_booking(
room_booking_id int,
paying_guest_id int,
room_id int,
--paymentstatusid
paymentstatusid int,
check_in date,
check_out date,
travelagency varchar(20),
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
maxresidents int,
costpernight int,
primary key (type_id)
);