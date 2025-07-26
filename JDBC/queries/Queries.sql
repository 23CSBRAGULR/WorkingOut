show databases;

create database learn;

use learn;
create table marks (roll int primary key, name varchar(15), marks int);
insert into marks values (101, 'Ragul', 90),
(102, 'Varshini', 80),
(103, 'Mathavan', 70),
(104, 'Sankar', 85),
(105, 'Ram', 75);

select * from marks;

show tables;

select*from test;

describe test;

update test set marks = 2 where id = 5;