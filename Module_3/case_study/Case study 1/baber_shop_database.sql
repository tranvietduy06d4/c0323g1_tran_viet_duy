create database baber_shop;
use baber_shop;


create table service(
service_id int primary key,
service_name varchar(255) not null,
price double not null,
service_quantity int not null,
execution_time datetime not null,
status bit(1));



create table employee (
employee_id int primary key,
employee_name varchar(255) not null,
birthday date not null,
salary double not null,
phone_number varchar(10) not null unique,
gender bit not null,
start_date datetime not null,
id_card varchar(12) not null unique,
address varchar(255) not null,
employee_status bit not null,
level varchar(50)
);

create table account_employee (
employee_id int primary key ,
user_employee varchar(255) not null unique,
passwword varchar(50) not null,
foreign key (employee_id) references employee (employee_id)
);



create table customer(
customer_id int primary key,
customer_name varchar(255) not null,
birthday date,
phone_number varchar(10),
gender bit not null,
address varchar(255) ,
customer_type varchar(50)
);
create table account_customer(
customer_id int primary key auto_increment,
user_customer varchar(255) not null,
password varchar(50) not null,
foreign key (customer_id) references customer(customer_id)
);

create table booking(
booking_id int primary key,
booking_date datetime not null
);

create table booking_detail_service(
service_id int not null,
booking_id int not null,
primary key(service_id,booking_id),
foreign key(service_id)references service(service_id),
foreign key(booking_id)references booking(booking_id)
);

create table booking_detail_customer(
booking_id int,
customer_id int,
primary key(booking_id,customer_id),
foreign key (customer_id) references customer (customer_id),
foreign key (booking_id) references booking (booking_id)
);
create table booking_detail_employee (
booking_id int,
employee_id int,
primary key (booking_id,employee_id),
foreign key (employee_id) references employee(employee_id),
foreign key (booking_id) references booking(booking_id)
);

