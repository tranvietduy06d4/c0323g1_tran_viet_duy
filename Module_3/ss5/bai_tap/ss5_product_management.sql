create database product_management;
use product_management;

create table products(
id int primary key,
product_code int not null,
product_name varchar(255) not null,
product_price double not null,
product_amount int,
product_description varchar(255),
product_status varchar(255)
);


