SHOW  DATABASEs;
use mengfh;
use mysql;
SHOW CREATE DATABASE mengfh;
desc student;
show create table student;
show tables;
select stuid,count(*) stuid的个数 from score group by stuid having count(*) > 5
select * from student;
select * from teacher;
select * from score;
select * from courses;

insert into student (stuname, stuage, teacherid) values ( 'dinyum2', 12, 1);
insert into student ( stuname, stuage, teacherid) values ( 'mengw2', 13, 2);
insert into student ( stuname, stuage, teacherid) values ( 'mengfh33', 14, 1);
insert into student ( stuname, stuage, teacherid) values ( 'mengfh44', 19, 1);

insert into teacher (id, teachername, teacherage) values (3, 'dinyum2', 38);
insert into teacher (id, teachername, teacherage) values (4, 'mengw2', 40);

update student set stuname = 'mengfh1' where id = 1
update student set stuname = 'mengfh2' where id = 2
update student set stuname = 'mengfh6' where id = 6
update student set stuname = 'mengfh7' where id = 7

update courses set teacherid = 3 where id = 3;
update courses set teacherid = 4 where id = 4;
delete from score where id = 2

insert into score (stuid, coursesid, scores) values ( 8, 3, 97.0);
insert into score (stuid, coursesid, scores) values ( 8, 4, 82.0);
insert into score (stuid, coursesid, scores) values ( 8, 5, 47.0);
insert into score (stuid, coursesid, scores) values ( 8, 6, 82.0);
insert into score (stuid, coursesid, scores) values ( 8, 7, 57.0);
insert into score (stuid, coursesid, scores) values ( 8, 8, 62.0);
insert into score (stuid, coursesid, scores) values ( 8, 1, 94.0);
insert into score (stuid, coursesid, scores) values ( 8, 2, 82.0);

ALTER TABLE score ADD COLUMN col1 INT FIRST;
ALTER TABLE score CHANGE scores score CHAR(30);

alter table score add clounm

create view view1 as select * from student
create view view1 as select stu.stuname, tea.teachername from student stu inner join  teacher tea on stu.teacherid = tea.id
describe view1;

select * from student_copy

create temporary table student_copy(
　　id int primary key,
　　name varchar(20) 
)Engine=InnoDB default charset utf8;

insert into student_copy values
(1,'1')

select * from teacher
show create table teacher
show index from teacher;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(20) DEFAULT NULL,
  `stuage` int(11) DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stuname` (`stuname`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8
desc student;
alter table student add unique key age
-- 假设建表时fileuploadercode字段没创建索引(注:同一个字段可以创建多个索引，但一般情况下意义不大)
-- 给projectfile表中的fileuploadercode创建索引
ALTER TABLE teacher ADD UNIQUE INDEX (teachername);
ALTER TABLE teacher ADD UNIQUE INDEX (teacherage);
ALTER TABLE 表名 ADD [UNIQUE | FULLTEXT | SPATIAL]  INDEX | KEY  [索引名] (字段名1 [(长度)] [ASC | DESC]) [USING 索引方法]；
ALTER TABLE teacher ADD UNIQUE key  test (teacherage);

EXPLAIN SELECT * FROM student  WHERE student.stuname = 'mengfh';
EXPLAIN SELECT * FROM student  WHERE student.id = 1;
EXPLAIN SELECT * FROM student  WHERE student.stuage = 12;
EXPLAIN SELECT * FROM student  WHERE student.id = '1';