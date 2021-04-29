select subcode, subname from subject where subcode = 5;

insert into student value (20031, '하하하', 1);

insert into classr values (1, 'A01'), (2, 'A02');

insert into score values (31, 20031, 01, 88);
update score set subscore = 90 where stdno = 20031 and subcode = 01;

insert into subject values (01, '국어'), (02, '영어'), (03, '수학'), (04,'사회'), (05, '과학');

insert into student values
	(20001, '박재선', 1), (20002, '한동선', 1), (20003, '정정일', 1), (20004, '정명훈', 1),
	(20005, '임정만', 1), (20006, '임성준', 1), (20007, '윤석수', 1), (20008, '이준민', 1),
	(20009, '이강길', 1), (20010, '박철호', 1), (20011, '여재일', 1), (20012, '박상엽', 1),
	(20013, '간효상', 1), (20014, '형동훈', 1), (20015, '진인우', 1), (20016, '박운승', 2),
	(20017, '김윤재', 2), (20018, '황보동명', 2), (20019, '사대호', 2), (20020, '박동수', 2),
	(20021, '안추환', 2), (20022, '정문식', 2), (20023, '윤대건', 2), (20024, '양우준', 2),
	(20025, '서동윤', 2), (20026, '송무길', 2), (20027, '박영우', 2), (20028, '신우석', 2),
	(20029, '이보민', 2), (20030, '조정우', 2);
	
insert into score values
	(1, 20001, 01, 72), (1, 20001, 02, 73), (1, 20001, 03, 90), (1, 20001, 04, 72), (1, 20001, 05, 84),
	(2, 20002, 01, 83), (2, 20002, 02, 72), (2, 20002, 03, 83), (2, 20002, 04, 90), (2, 20002, 05, 91),
	(3, 20003, 01, 88), (3, 20003, 02, 72), (3, 20003, 03, 92), (3, 20003, 04, 88), (3, 20003, 05, 99),
	(4, 20004, 01, 90), (4, 20004, 02, 70), (4, 20004, 03, 82), (4, 20004, 04, 93), (4, 20004, 05, 98),
	(5, 20005, 01, 78), (5, 20005, 02, 95), (5, 20005, 03, 79), (5, 20005, 04, 79), (5, 20005, 05, 97),
	(6, 20006, 01, 77), (6, 20006, 02, 95), (6, 20006, 03, 87), (6, 20006, 04, 81), (6, 20006, 05, 85),
	(7, 20007, 01, 71), (7, 20007, 02, 72), (7, 20007, 03, 92), (7, 20007, 04, 91), (7, 20007, 05, 96),
	(8, 20008, 01, 95), (8, 20008, 02, 94), (8, 20008, 03, 93), (8, 20008, 04, 88), (8, 20008, 05, 100),
	(9, 20009, 01, 97), (9, 20009, 02, 78), (9, 20009, 03, 78), (9, 20009, 04, 90), (9, 20009, 05, 73),
	(10, 20010, 01, 95), (10, 20010, 02, 78), (10, 20010, 03, 80), (10, 20010, 04, 92), (10, 20010, 05, 72),
	(11, 20011, 01, 96), (11, 20011, 02, 72), (11, 20011, 03, 75), (11, 20011, 04, 81), (11, 20011, 05, 81),
	(12, 20012, 01, 89), (12, 20012, 02, 93), (12, 20012, 03, 100), (12, 20012, 04, 88), (12, 20012, 05, 83),
	(13, 20013, 01, 73), (13, 20013, 02, 82), (13, 20013, 03, 95), (13, 20013, 04, 76), (13, 20013, 05, 90),
	(14, 20014, 01, 87), (14, 20014, 02, 90), (14, 20014, 03, 92), (14, 20014, 04, 96), (14, 20014, 05, 73),
	(15, 20015, 01, 94), (15, 20015, 02, 75), (15, 20015, 03, 76), (15, 20015, 04, 97), (15, 20015, 05, 75),
	(16, 20016, 01, 84), (16, 20016, 02, 97), (16, 20016, 03, 88), (16, 20016, 04, 87), (16, 20016, 05, 85),
	(17, 20017, 01, 77), (17, 20017, 02, 83), (17, 20017, 03, 70), (17, 20017, 04, 98), (17, 20017, 05, 88),
	(18, 20018, 01, 81), (18, 20018, 02, 90), (18, 20018, 03, 74), (18, 20018, 04, 73), (18, 20018, 05, 73),
	(19, 20019, 01, 71), (19, 20019, 02, 83), (19, 20019, 03, 79), (19, 20019, 04, 99), (19, 20019, 05, 83),
	(20, 20020, 01, 86), (20, 20020, 02, 98), (20, 20020, 03, 92), (20, 20020, 04, 81), (20, 20020, 05, 73),
	(21, 20021, 01, 98), (21, 20021, 02, 97), (21, 20021, 03, 93), (21, 20021, 04, 90), (21, 20021, 05, 71),
	(22, 20022, 01, 92), (22, 20022, 02, 80), (22, 20022, 03, 75), (22, 20022, 04, 81), (22, 20022, 05, 100),
	(23, 20023, 01, 87), (23, 20023, 02, 77), (23, 20023, 03, 85), (23, 20023, 04, 78), (23, 20023, 05, 78),
	(24, 20024, 01, 95), (24, 20024, 02, 84), (24, 20024, 03, 73), (24, 20024, 04, 76), (24, 20024, 05, 84),
	(25, 20025, 01, 95), (25, 20025, 02, 96), (25, 20025, 03, 98), (25, 20025, 04, 100), (25, 20025, 05, 77),
	(26, 20026, 01, 77), (26, 20026, 02, 80), (26, 20026, 03, 78), (26, 20026, 04, 99), (26, 20026, 05, 82),
	(27, 20027, 01, 84), (27, 20027, 02, 74), (27, 20027, 03, 95), (27, 20027, 04, 76), (27, 20027, 05, 96),
	(28, 20028, 01, 70), (28, 20028, 02, 78), (28, 20028, 03, 77), (28, 20028, 04, 97), (28, 20028, 05, 71),
	(29, 20029, 01, 100), (29, 20029, 02, 76), (29, 20029, 03, 96), (29, 20029, 04, 75), (29, 20029, 05, 87),
	(30, 20030, 01, 74), (30, 20030, 02, 78), (30, 20030, 03, 93), (30, 20030, 04, 83), (30, 20030, 05, 73);