
insert into room_type values (1, 'single', 1, 10);
insert into room_type values (1, 'double', 2, 15);
insert into room_type values (1, 'family', 5, 25);

insert into room values(001, 1);
insert into room values(002, 1);
insert into room values(003, 1);
insert into room values(004, 1);
insert into room values(005, 1);
insert into room values(006, 1);
insert into room values(007, 1);
insert into room values(008, 1);
insert into room values(009, 1);
insert into room values(010, 1);
insert into room values(101, 2);
insert into room values(102, 2);
insert into room values(103, 2);
insert into room values(104, 2);
insert into room values(105, 2);
insert into room values(201, 3);
insert into room values(202, 3);
insert into room values(203, 3);
insert into room values(204, 3);

insert into PaymentStatus values(1, 'not paid');
insert into PaymentStatus values(2, 'depositum paid');
insert into PaymentStatus values(3, 'room paid');

DELETE FROM paymentstatus, room, room_type
WHERE room_id, payment_id, room_type_id => 0;