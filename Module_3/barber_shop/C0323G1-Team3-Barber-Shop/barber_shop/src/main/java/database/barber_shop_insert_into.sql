use barber_shop;

insert into customer_type(customer_type_name) values("Member");
insert into customer_type(customer_type_name) values("Gold");
insert into customer_type(customer_type_name) values("Diamond");

insert into role (role_name)
values ("Khách hàng"),("Nhân viên"),("Admin");
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus1', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus2', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus3', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus4', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus5', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus6', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus7', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus8', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus9', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('cus10', '123', '1');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('em1', '123', '2');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('em2', '123', '2');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('em3', '123', '2');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('em4', '123', '2');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('em5', '123', '2');
INSERT INTO `barber_shop`.`account` (`username`, `password`, `role_id`) VALUES ('adm', '123', '3');


INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Cắt tóc', 50000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Gội đầu', 30000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Cạo mặt', 20000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Lấy ráy tai', 20000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Nhuộm tóc', 300000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Uốn tóc', 300000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Combo truyền thống (cắt,gội,sấy)', 100000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Combo vip 1 (Cắt, gội, sấy, matxa, cạo mặt)', 120000);
INSERT INTO `barber_shop`.`service` (`service_name`, `price`) VALUES ('Combo vip 2 (Uốn, nhuộm tóc)', 500000);


INSERT INTO `barber_shop`.`employee` (`employee_name`, `birthday`, `salary`, `phone_number`, `gender`, `id_card`, `address`, `account_id`)
VALUES ('Kim Ngọc Thành', '2001-09-13', 9000000, '0961297922', 1, '001201011357', 'Hà Nội', 11);
INSERT INTO `barber_shop`.`employee` (`employee_name`, `birthday`, `salary`, `phone_number`, `gender`, `id_card`, `address`, `account_id`)
VALUES ('Huỳnh Lê Tấn Cường', '1996-01-01', 8000000, '0983391536', 1, '001201011358', 'Đà Nẵng', 12);
INSERT INTO `barber_shop`.`employee` (`employee_name`, `birthday`, `salary`, `phone_number`, `gender`,  `id_card`, `address`, `account_id`)
VALUES ('Trần Việt Duy', '1989-04-05', 7000000, '0386981720', 1, '001201011355', 'Hồ Chí Minh', 13);
INSERT INTO `barber_shop`.`employee` (`employee_name`, `birthday`, `salary`, `phone_number`, `gender`,  `id_card`, `address`, `account_id`)
VALUES ('Ngô Đình Quân', '1998-09-10', 7000000, '0355657784', 1,  '001201011322', 'Cần Thơ', 14);
INSERT INTO `barber_shop`.`employee` (`employee_name`, `birthday`, `salary`, `phone_number`, `gender`, `id_card`, `address`, `account_id`)
VALUES ('Trần Minh Pháp', '1998-01-01', 6000000, '0254123451', 1, '001201011999', 'Bình Dương', 15);


INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Nguyễn Thành Thân', '2001-01-01', '0977754321', 1, 'Đà nẵng', 1, 1);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Trần Mỹ Duyên', '2000-01-01', '0985555321', 1, 'Hà Nội', 1, 2);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Huỳnh Công Duy', '2005-01-01', '0900000321', 1, 'Sài Gòn', 1, 3);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Phạm Khách Duy', '2003-01-01', '0987114321', 1, 'Bình Dương', 1, 4);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Nguyễn Thị Lan', '1999-01-01', '0987644321', 1, 'Đà nẵng', 1, 5);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Nguyễn Tiến Đạt', '1989-01-01', '0987774321', 1, 'Đà nẵng', 1, 6);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Ngô Ngữ Hoàng Nhật', '2003-01-01', '0997654321', 1, 'Hà Nội', 1, 7);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Nguyễn Phúc Quý', '2001-02-01', '0987754321', 1, 'Hải Dương', 1, 8);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Trần Viết Cao', '2001-01-02', '0987652321', 1, 'Quảng Nam', 1, 9);
INSERT INTO `barber_shop`.`customer` (`customer_name`, `birthday`, `phone_number`, `gender`, `address`, `customer_type_id`, `account_id`) VALUES ('Phạm Thị Huyền', '2001-02-01', '0987114321', 1, 'Đà nẵng', 1, 10);


INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-09-07', 1, 1);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-09-06', 2, 1);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-09-06', 3, 1);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-09-05', 4, 1);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-03-05', 5, 0);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-03-04', 6, 0);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-04-04', 7, 0);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-01-03', 8, 0);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-02-03', 9, 0);
INSERT INTO `barber_shop`.`booking` (`booking_date`, `account_id`, `booking_status`) VALUES ('2023-02-03', 10, 0);


INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('1', '1');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('1', '2');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('2', '2');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('2', '3');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('9', '4');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('3', '5');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('4', '6');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('1', '7');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('1', '8');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('2', '9');
INSERT INTO `barber_shop`.`booking_detail_service` (`service_id`, `booking_id`) VALUES ('6', '10');