create database ornek;

use ornek;

create table student(
	student_number int primary key,
	name varchar(50),
    surname varchar(50),
    password varchar(32)
);

insert into student values ("313933", "Muhammet Mucahit", "AKTEPE", "1234");
insert into student values ("313936", "Mehmet Alperen", "CUBUK", "1234");

select * from student;

drop table student;

update student set student_number = 313932, name = "Mucahit", surname = "Aktepe", password = "4321" where student_number = 313933;