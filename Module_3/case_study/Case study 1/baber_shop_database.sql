create database barber_shop;
use barber_shop;
create table role(
role_id int primary key,
role_name varchar(50) not null
);
create table account(
account_id int primary key,
user_employee VARCHAR(255) NOT NULL UNIQUE,
    passwword VARCHAR(50) NOT NULL,
    role_id int not null,
    foreign key(role_id) references role (role_id)
);
CREATE TABLE service (
    service_id INT PRIMARY KEY ,
    service_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    service_quantity INT NOT NULL,
    execution_time DATETIME NOT NULL,
    status BIT(1)
);
CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    salary DOUBLE NOT NULL,
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    gender BIT NOT NULL,
    start_date DATETIME NOT NULL,
    id_card VARCHAR(12) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    employee_status BIT NOT NULL,
    account_id int not null,
    foreign key(account_id) references account(account_id)
);
CREATE TABLE customer_type (
    customer_type_id INT PRIMARY KEY,
    customer_type_name VARCHAR(50)
);
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    birthday DATE,
    phone_number VARCHAR(10),
    gender BIT NOT NULL,
    address VARCHAR(255),
    customer_type_id INT NOT NULL,
    account_id int not null,
    foreign key(account_id) references account(account_id),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
);
CREATE TABLE booking (
    booking_id INT PRIMARY KEY,
    booking_date DATE NOT NULL,
    customer_id INT,
    status varchar(255),
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
);
CREATE TABLE booking_detail_employee (
    booking_detail_employee_id INT PRIMARY KEY,
    booking_id INT NOT NULL,
    employee_id INT NOT NULL,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (booking_id)
        REFERENCES booking (booking_id)
);
CREATE TABLE booking_detail_service (
    booking_detail_service_id INT PRIMARY KEY,
    service_id INT NOT NULL,
    booking_id INT NOT NULL,
    FOREIGN KEY (service_id)
        REFERENCES service (service_id),
    FOREIGN KEY (booking_id)
        REFERENCES booking (booking_id)
);