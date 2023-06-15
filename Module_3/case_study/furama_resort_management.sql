create database furama_resort_management;
use furama_resort_management;

create table employee_position(
position_ID int primary key,
position_name varchar(45)
);

create table employee_level(
level_ID int primary key,
level_name varchar(45)
);

create table department(
department_ID int primary key,
department_name varchar(45)
);

create table employee(
employee_ID int primary key,
employee_name varchar(45),
employee_birthday date,
employee_code varchar(45),
salary double,
phone_number varchar(45),
email varchar(45),
address varchar(45),
position_ID int not null,
foreign key(position_ID) references employee_position(position_ID),
level_ID int not null,
foreign key(level_ID) references employee_level(level_ID),
department_ID int not null,
foreign key(department_ID) references department(department_ID)
);

create table customer_type(
customer_type_ID int primary key,
customer_type_name varchar(45)
);

create table customer(
customer_ID int primary key,
customer_type_ID int,
foreign key(customer_type_ID) references customer_type(customer_type_ID),
customer_name varchar(45),
customer_birthday date,
gender bit(1),
customer_code varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45)
);

create table service_type(
service_type_ID int primary key,
service_type_name varchar(45)
);

create table rent_type(
rent_type_ID int primary key,
rent_type_name varchar(45)
);

create table service(
service_ID int primary key,
service_name varchar(45),
service_area int,
rent_fee double,
maxium_person int,
rent_type_ID int not null,
foreign key(rent_type_ID) references rent_type(rent_type_ID),
service_type_ID int not null,
foreign key(service_type_ID) references service_type(service_type_ID),
room_standard varchar(45),
other_description varchar(45),
pool_area double,
floor_amount int
);

create table constract(
constract_ID int primary key,
begin_date date,
end_date date,
deposit_money double,
employee_ID int not null,
foreign key(employee_ID) references employee(employee_ID),
customer_ID int not null,
foreign key(customer_ID) references customer(customer_ID),
service_ID int not null,
foreign key(service_ID) references service(service_ID)
);

create table addtional_service(
additional_service_ID int primary key,
additional_service_name varchar(45),
additional_service_price double,
unit varchar(10),
status varchar(45)
);

create table constract_detail(
constract_detail_ID int primary key,
constract_ID int,
foreign key(constract_ID) references constract(constract_ID),
additional_service_ID int,
foreign key(additional_service_ID) references addtional_service(additional_service_ID),
quantity int
);
