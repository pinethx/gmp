select user(), database ();

create database grade_management;
use grade_management ;
drop database grade_management;


-- 성적관리프로그램
DROP SCHEMA IF EXISTS grade_management;

-- 성적관리프로그램
CREATE SCHEMA grade_management;

-- 학생
CREATE TABLE student (
	stdno   INT         NOT NULL COMMENT '학번', -- 학번
	stdname VARCHAR(10) NOT NULL COMMENT '이름', -- 이름
	classno int		    NOT NULL COMMENT '분반' -- 분반
)
COMMENT '학생';

-- 학생
ALTER TABLE student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			stdno -- 학번
		);

-- 분반
CREATE TABLE classr (
	classno int		NOT NULL COMMENT '분반코드', -- 분반코드
	classrm char(3) NOT NULL COMMENT '분반' -- 분반
)
COMMENT '분반';

-- 분반
ALTER TABLE classr
	ADD CONSTRAINT PK_classr -- 분반 기본키
		PRIMARY KEY (
			classno -- 분반
		);

-- 점수
CREATE TABLE score (
	no       INT NULL     COMMENT '연번', -- 연번
	stdno    INT NOT NULL COMMENT '학번', -- 학번
	subcode  INT NOT NULL COMMENT '과목코드', -- 과목코드
	subscore INT NULL     COMMENT '과목점수' -- 과목점수
)
COMMENT '점수';

-- 점수
ALTER TABLE score
	ADD CONSTRAINT PK_score -- 점수 기본키
		PRIMARY KEY (
			stdno,   -- 학번
			subcode  -- 과목코드
		);

-- 과목
CREATE TABLE subject (
	subcode INT         NOT NULL COMMENT '과목코드', -- 과목코드
	subname VARCHAR(10) NULL     COMMENT '과목이름' -- 과목이름
)
COMMENT '과목';

-- 과목
ALTER TABLE subject
	ADD CONSTRAINT PK_subject -- 과목 기본키
		PRIMARY KEY (
			subcode -- 과목코드
		);

-- 학생
ALTER TABLE student
	ADD CONSTRAINT FK_classr_TO_student -- 분반 -> 학생
		FOREIGN KEY (
			classno -- 분반
		)
		REFERENCES classr ( -- 분반
			classno -- 분반
		);

-- 점수
ALTER TABLE score
	ADD CONSTRAINT FK_subject_TO_score -- 과목 -> 점수
		FOREIGN KEY (
			subcode -- 과목코드
		)
		REFERENCES subject ( -- 과목
			subcode -- 과목코드
		);

-- 점수
ALTER TABLE score
	ADD CONSTRAINT FK_student_TO_score -- 학생 -> 점수
		FOREIGN KEY (
			stdno -- 학번
		)
		REFERENCES student ( -- 학생
			stdno -- 학번
		);
		
	
select no, stdno, subcode, subscore 
  from score;
  
select stdno, stdname, classR 
  from student;
  
select subcode, subname 
  from subject ;
  
select classno, classrm
  from classr;