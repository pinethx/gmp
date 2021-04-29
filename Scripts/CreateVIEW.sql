create or replace view vw_full_student
as
select s.stdno
     , s.stdname
     , s.classno
     , sr.classrm
  from student s join score sc on s.stdno = sc.stdno join classr sr on s.classno = sr.classno
 group by s.stdno;
 
select stdno, stdname, classrm from vw_full_student;
select no, stdno, stdname, subcode, subname, subscore from vw_score;

create or replace view vw_score
as
select sc.no
     , sc.stdno
     , std.stdname
     , sc.subcode
     , sb.subname
     , sc.subscore
  from score sc join subject sb on sc.subcode = sb.subcode join student std on sc.stdno = std.stdno;

select no, stdname, subname, subscore from vw_score;

create or replace view vw_full_score
as
select sc.no
     , s.stdno
     , s.stdname
     , sr.classno
     , sr.classrm
     , max(if (sb.subname = '국어', sc.subcode , 0)) as 'sub1'
     , max(if (sb.subname = '영어', sc.subcode , 0)) as 'sub2'
     , max(if (sb.subname = '수학', sc.subcode , 0)) as 'sub3'
     , max(if (sb.subname = '사회', sc.subcode , 0)) as 'sub4'
     , max(if (sb.subname = '과학', sc.subcode , 0)) as 'sub5'
     , max(if (sc.subcode = 01, sb.subname, 0)) as 'subn1'
     , max(if (sc.subcode = 02, sb.subname, 0)) as 'subn2'
     , max(if (sc.subcode = 03, sb.subname, 0)) as 'subn3'
     , max(if (sc.subcode = 04, sb.subname, 0)) as 'subn4'
     , max(if (sc.subcode = 05, sb.subname, 0)) as 'subn5'
     , max(if (sc.subcode = 01, sc.subscore , 0)) as '국어'
     , max(if (sc.subcode = 02, sc.subscore , 0)) as '영어'
     , max(if (sc.subcode = 03, sc.subscore , 0)) as '수학'
     , max(if (sc.subcode = 04, sc.subscore , 0)) as '사회'
     , max(if (sc.subcode = 05, sc.subscore , 0)) as '과학'
     , sum(sc.subscore) as '합계'
     , sum(sc.subscore)/5 as '평균'
  from student s join score sc on s.stdno = sc.stdno join classr sr on s.classno = sr.classno join subject sb on sc.subcode = sb.subcode
 group by s.stdno;



select * from vw_full_score;
select sc.no
     , s.stdno
     , s.stdname 
     , s.classno
     , sc.subcode as 과목
     , sc.subcode as 점수
  from student s join score sc on s.stdno = sc.stdno
 group by s.stdno;
 
-- 특정 분반 조회 sql문
select no
     , stdno
     , stdname
     , classrm
     , 국어
     , 영어
     , 수학
     , 사회
     , 과학
     , 합계
     , 평균
  from vw_full_score;
 
-- insert sql문

select sc.stdno as '학번', 
	   s.stdname as '이름',
	   sum(if(subcode=01, subscore, 0)) as '국어',
	   sum(if(subcode=02, subscore, 0)) as '영어',
	   sum(if(subcode=03, subscore, 0)) as '수학',
	   sum(if(subcode=04, subscore, 0)) as '사회',
	   sum(if(subcode=05, subscore, 0)) as '과학'
  from score sc join student s on sc.stdno = s.stdno
 group by stdno;
