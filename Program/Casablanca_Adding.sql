

insert into room values(1, '001', 'Single', 1, 10);
insert into room values(2, '002', 'Single', 1, 10);
insert into room values(3, '003', 'Single', 1, 10);
insert into room values(4, '004', 'Single', 1, 10);
insert into room values(5, '005', 'Single', 1, 10);
insert into room values(6, '006', 'Single', 1, 10);
insert into room values(7, '007', 'Single', 1, 10);
insert into room values(8, '008', 'Single', 1, 10);
insert into room values(9, '009', 'Single', 1, 10);
insert into room values(10, '010', 'Single', 1, 10);
insert into room values(11, '101', 'Double', 2, 20);
insert into room values(12, '102', 'Double', 2, 20);
insert into room values(13, '103', 'Double', 2, 20);
insert into room values(14, '104', 'Double', 2, 20);
insert into room values(15, '105', 'Double', 2, 20);
insert into room values(16, '201', 'Family', 4, 35);
insert into room values(17, '202', 'Family', 4, 35);
insert into room values(18, '203', 'Family', 4, 35);
insert into room values(19, '204', 'Family', 4, 35);

insert into paying_guest values (1, 'Sven', 'Holmager', 'Brovænget 11', 'Denmark', '22 22 22 30', 'sholmager@gmail.com');
insert into paying_guest values (2, 'Dragos', 'Ilici', 'Albertslund', 'denmark', ' 66 66 66 44', 'somewthing@wegw.com');

insert into room_booking values(1, 1, 001,  '11-Nov-1999',  '13-Nov-1999', 'Spies rejser', 'Paid');

insert into staying_guest values (1, 1, 'Sven', 'Holmager');

insert into activity_type values (1, 'Tennis', 1);
insert into activity_type values (2, 'Badminton', 1);
insert into activity_type values (3, 'Volley Ball', null);
insert into activity_type values (4, 'Handball', null);
insert into activity_type values (5, 'Fitness', 20);
insert into activity_type values (6, 'Golf', null);
insert into activity_type values (7, 'Mountain Bike', 1);
insert into activity_type values (8, 'Swimming', null);
insert into activity_type values (9, 'Table tennis', 1);

insert into activity values (1, 1, 'Tennis court 1');
insert into activity values (2, 1, 'Tennis court 2');
insert into activity values (3, 1, 'Tennis court 3');
insert into activity values (4, 1, 'Tennis court 4');
insert into activity values (5, 1, 'Tennis court 5');
insert into activity values (6, 1, 'Tennis court 6');
insert into activity values (7, 2, 'Badminton court 1');
insert into activity values (8, 2, 'Badminton court 2');
insert into activity values (9, 2, 'Badminton court 3');
insert into activity values (10, 2, 'Badminton court 4');
insert into activity values (11, 3, 'Volleyball court 1');
insert into activity values (12, 3, 'Volleyball court 2');
insert into activity values (13, 4, 'Team Handball court 1');
insert into activity values (14, 4, 'Team Handball court 2');
insert into activity values (15, 5, 'Fitness center');

insert into activity values (16, 6, 'Golf');
insert into activity values (17, 7, 'Mountain biking');
insert into activity values (18, 8, 'Swimming');
insert into activity values (19, 9, 'Table tennis');





