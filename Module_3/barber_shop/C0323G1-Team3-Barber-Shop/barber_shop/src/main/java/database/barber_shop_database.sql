create database barber_shop;
use barber_shop;
CREATE TABLE role (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL
);
CREATE TABLE account (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id)
        REFERENCES role (role_id)
);
CREATE TABLE service (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    service_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    service_quantity INT NOT NULL,
    status BIT(1)
);
CREATE TABLE employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(255) NOT NULL,
    birthday varchar(50) NOT NULL,
    salary DOUBLE NOT NULL,
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    gender BIT NOT NULL,
    start_date varchar(50) NOT NULL,
    id_card VARCHAR(12) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    employee_status BIT NOT NULL,
    account_id INT NOT NULL,
    FOREIGN KEY (account_id)
        REFERENCES account (account_id)
);
CREATE TABLE customer_type (
    customer_type_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_type_name VARCHAR(50)
);
CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    birthday varchar(50),
    phone_number VARCHAR(10),
    gender BIT NOT NULL,
    address VARCHAR(255),
    customer_type_id INT NOT NULL,
    account_id INT NOT NULL,
    FOREIGN KEY (account_id)
        REFERENCES account (account_id),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
);
CREATE TABLE booking (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_date varchar(50) NOT NULL,
    customer_id INT,
    booking_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id)
);
CREATE TABLE booking_detail_employee (
    booking_detail_employee_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT NOT NULL,
    employee_id INT NOT NULL,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (booking_id)
        REFERENCES booking (booking_id)
);
CREATE TABLE booking_detail_service (
    booking_detail_service_id INT PRIMARY KEY AUTO_INCREMENT,
    service_id INT NOT NULL,
    booking_id INT NOT NULL,
    FOREIGN KEY (service_id)
        REFERENCES service (service_id),
    FOREIGN KEY (booking_id)
        REFERENCES booking (booking_id)
);