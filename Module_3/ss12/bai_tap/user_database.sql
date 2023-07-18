create database user_demo;
use user_demo;

create table users(
id int(3) primary key auto_increment,
name varchar(120) not null,
email varchar(220) not null,
country varchar(120)
);

insert into users(name,email,country) 
values ('Minh','minh@codegym.vn','Viet Nam'), ('Kante','kante@che.uk','Kenia');

delimiter //
create procedure display_all()
begin
select *
from users;
end //
delimiter ;

delimiter //
create procedure delete_user(id int)
begin
delete
from users
where users.id = id;
end //
delimiter ;

delimiter //
create procedure edit_user(name varchar(120),email varchar(220), country varchar(120), id int)
begin
update users
set users.name = name, users.email = email, users.country = country
where users.id = id;
end //
delimiter ;



