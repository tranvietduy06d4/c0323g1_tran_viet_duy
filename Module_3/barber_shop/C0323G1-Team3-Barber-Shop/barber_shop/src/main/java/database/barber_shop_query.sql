use barber_shop;

delimiter //
create procedure display_all()
begin
select *
from employee;
end //
delimiter ;


delimiter //
create procedure add_employee(employee_name varchar(255), birthday varchar(10), salary double, phone_number varchar(10), gender bit, id_card varchar(12), address varchar(255), account_id int)
begin
insert into employee(employee.employee_name,employee.birthday,employee.salary,employee.phone_number,employee.gender,employee.id_card,employee.address,employee.account_id)
values (employee_name,birthday,salary,phone_number,gender,id_card,address,account_id);
end //
delimiter ;


delimiter //
create procedure edit_employee(employee_id int, employee_name varchar(255), birthday date, salary double, phone_number varchar(10), gender bit, id_card varchar(12), address varchar(255))
begin
SET SQL_SAFE_UPDATES = 0;
update employee
set employee.employee_name = employee_name, employee.birthday = birthday, employee.salary = salary, employee.phone_number=phone_number, employee.gender = gender,employee.id_card = id_card,employee.address = address
where employee.employee_id = employee_id;
SET SQL_SAFE_UPDATES = 1;
end //
delimiter ;
call edit_employee(1,"a","1999-05-05",1,"102",1,5,"A");

delimiter //
create procedure delete_employee(employee_id int)
begin
delete from employee
where employee.employee_id=employee_id;
end //


delimiter //
create procedure get_list_account()
begin
select employee.employee_name as name,account.username,account.password,account.account_id,role.role_name
from account
join role on account.role_id=role.role_id
right join employee on account.account_id=employee.account_id
UNION ALL
select customer.customer_name,account.username,account.password,account.account_id,role.role_name
from account
join role on account.role_id=role.role_id
right join customer on account.account_id=customer.account_id;
end //
delimiter ;


delimiter //
create procedure select_booking()
begin
select c.customer_name, b.booking_date,b.booking_status, sum(s.price) as sum
from booking b
join account a on b.account_id = a.account_id
join customer c on a.account_id = c.account_id
join booking_detail_service bds on b.booking_id = bds.booking_id
join service s on bds.service_id = s.service_id
group by c.customer_name,  b.booking_id
order by b.booking_date desc;
end //
delimiter ;



delimiter //
create procedure select_booking_emp()
begin
select c.customer_name, b.booking_date,b.booking_status, sum(s.price) as sum
from booking b
join account a on b.account_id = a.account_id
join customer c on a.account_id = c.account_id
join booking_detail_service bds on b.booking_id = bds.booking_id
join service s on bds.service_id = s.service_id
where b.booking_date >= curdate()
group by c.customer_name,  b.booking_id
order by b.booking_date desc;
end //
delimiter ;


delimiter //
create procedure select_booking_history(in booking_id int)
begin
SELECT c.customer_name, b.booking_date, b.booking_id, SUM(s.price) AS total_price
FROM booking b
JOIN account a ON b.account_id = a.account_id
JOIN customer c ON a.account_id = c.account_id
JOIN booking_detail_service bds ON b.booking_id = bds.booking_id
JOIN service s ON bds.service_id = s.service_id
WHERE b.account_id = booking_id
GROUP BY c.customer_name, b.booking_date, b.booking_id
order by b.booking_date desc;
end //
delimiter ;


call select_booking_history(2)  ;
delimiter //
create procedure select_booking_dto(in id int)
begin
select c.customer_name, b.booking_date, sum(s.price) as sum
from booking b
join account a on b.account_id = a.account_id
join customer c on a.account_id = c.account_id
join booking_detail_service bds on b.booking_id = bds.booking_id
join service s on bds.service_id = s.service_id
where b.account_id=id
group by c.customer_name,b.booking_id,b.booking_date
order by b.booking_date desc;
end //
delimiter ;


DELIMITER //
create procedure update_service(service_name varchar(255), price double, id int)
begin
update service
set service_name=service_name, price=price
where service_id = id;
end //
DELIMITER ;


DELIMITER //
create procedure insert_service(name varchar(255), price double)
begin
insert into service(service_name, price)
values (name,price);
end //
DELIMITER ;