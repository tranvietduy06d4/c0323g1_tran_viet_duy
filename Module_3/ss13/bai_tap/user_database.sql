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
