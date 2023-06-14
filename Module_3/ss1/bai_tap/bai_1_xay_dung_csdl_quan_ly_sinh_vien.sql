insert into student(idStudent,name,age,country)
values (1,'Duy',18,'Viet Nam');
insert into student(idStudent,name,age,country)
values (2,'Duy',18,'Viet Nam');
insert into student(idStudent,name,age,country)
values (3,'Minh',19,'Viet Nam');
insert into student(idStudent,name,age,country)
values (4,'Anna',19,'America');
update student
set name = 'Hoang'
where idStudent = 1;
select *
from student;
insert into teacher (id,name,age,country)
values (1,'Dung',26,'Viet Nam');
insert into teacher (id,name,age,country)
values (2,'Peter',30,'England');
insert into teacher (id,name,age,country)
values (3,'Hiroshi Taka',33,'Japan');
select *
from teacher order by age asc;
insert into class(id,name)
values (1,'C0323G1');
insert into class(id,name)
values (2,'C0423G1');
insert into class(id,name)
values (3,'C0523G1');
insert into class(id, name)
values(4,'C0223G1');
select *
from class;