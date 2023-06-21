use furama_resort_management;

--- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select *
from employee
where employee_name like 'H%' or employee_name like 'T%' or employee_name like 'K%' and length(employee_name) < 16;

--- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from customer
where (timestampdiff(year,customer_birthday,current_date()) >=18 and timestampdiff(year,customer_birthday,current_date())<=50 and (address like '%Đà Nẵng' or address like '%Quảng Trị'));

--- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select customer.customer_name, customer_type.customer_type_name, count(constract_ID) as rent_time_count
from customer
join constract on customer.customer_ID = constract.customer_ID
join customer_type on customer.customer_type_ID = customer_type.customer_type_ID
where customer_type.customer_type_name = 'Diamond'
group by customer.customer_name
order by rent_time_count;

--- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select customer.customer_ID, 
	customer.customer_name, 
	customer_type.customer_type_name,
	constract.constract_ID,
	service.service_name,
	constract.begin_date, 
	constract.end_date,
	service.rent_fee + addtional_service.additional_service_price * constract_detail.quantity as 'total_price'
from customer
left join customer_type on customer.customer_type_ID = customer_type.customer_type_ID
left join constract on customer.customer_ID = constract.customer_ID
left join service on constract.service_ID = service.service_ID
left join constract_detail on constract.constract_ID = constract_detail.constract_ID
left join addtional_service on constract_detail.additional_service_ID = addtional_service.additional_service_ID;


--- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

-- service: service_ID, service_name, service_area, ren_fee
-- service_type: service_type_name


select distinct service.service_ID, service.service_name, service.service_area, service.rent_fee, service_type.service_type_name
from service
left join constract on service.service_ID = constract.service_ID
left join service_type on service.service_type_ID = service_type.service_type_ID
where service.service_ID not in (
									select service.service_ID
                                    from constract
                                    join service on constract.service_ID = service.service_ID
                                    where (constract.begin_date between '2021-01-01' and '2021-03-31') )
order by service.service_name;


-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ 
-- đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021. 

SELECT 
    service.service_ID,
    service.service_name,
    service.service_area,
    service.maximum_person,
    service.rent_fee,
    service_type.service_type_name
FROM
    service
        LEFT JOIN
    constract ON service.service_ID = constract.service_ID
        JOIN
    service_type ON service.service_type_ID = service_type.service_type_ID
WHERE 
    YEAR(constract.begin_date) = 2020
        AND service.service_ID NOT IN (SELECT 
            service_ID
        FROM
            constract
        WHERE
            YEAR(constract.begin_date) = 2021)
GROUP BY service.service_ID;                            


-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.

select distinct customer.customer_name
from customer;

select customer_name
from customer
group by customer_name;

select customer_name
from customer
union
select customer_name
from customer;

-- Cau 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(constract.begin_date) as Month, count(constract.begin_date) as constract_amount
from constract
where year(constract.begin_date) = 2021
group by Month
order by Month;

-- Cau 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

SELECT 
    constract.constract_ID,
    constract.begin_date,
    constract.end_date,
    constract.deposit_money,
    ifnull (sum(constract_detail.quantity),0) as additional_service_quantity
FROM
    constract
       left JOIN
    constract_detail ON constract.constract_ID = constract_detail.constract_ID
GROUP BY constract.constract_ID;


-- Câu 11.	Hiển thị thông tin các dịch vụ đi kèm 
-- đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
-- và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

-- additional_service, customer, address, customer_type_name
SELECT 
    addtional_service.additional_service_ID,
    addtional_service.additional_service_name
FROM
    customer_type
        JOIN
    customer ON customer_type.customer_type_ID = customer.customer_type_ID
        JOIN
    constract ON customer.customer_ID = constract.customer_ID
        JOIN
    constract_detail ON constract.constract_ID = constract_detail.constract_ID
        JOIN
    addtional_service ON constract_detail.additional_service_ID = addtional_service.additional_service_ID
WHERE
    customer_type.customer_type_name = 'Diamond'
        AND (customer.address LIKE '%Vinh%'
        OR customer.address LIKE '%Quảng Ngãi%');


-- Câu 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ 
-- đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021. 

SELECT 
    constract.constract_ID,
    employee.employee_name,
    customer.customer_name,
    customer.phone_number,
    service.service_name,
    SUM(constract_detail.quantity) AS additional_service_amount,
    constract.deposit_money
FROM
    constract
        JOIN
    employee ON constract.employee_ID = employee.employee_ID
        JOIN
    customer ON constract.customer_ID = customer.customer_ID
        JOIN
    service ON constract.service_ID = service.service_ID
        LEFT JOIN
    constract_detail ON constract.constract_ID = constract_detail.constract_ID
WHERE
    constract.begin_date BETWEEN '2020-10-01' AND '2020-12-31'
        AND constract.constract_ID NOT IN (SELECT 
            constract.constract_ID
        FROM
            constract
        WHERE
            constract.begin_date BETWEEN '2021-01-01' AND '2021-06-30')
GROUP BY constract.constract_ID;


-- Cau 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select 	constract_detail.additional_service_ID,
		sum(constract_detail.quantity) as constract_amount
from constract_detail
group by constract_detail.additional_service_ID
having constract_amount = (select max(abc.sum)
from 	(select constract_detail.additional_service_ID, sum(constract_detail.quantity) as sum
		from constract_detail
		group by constract_detail.additional_service_ID) 
        abc);

select max(abc.sum)
from 	(select constract_detail.additional_service_ID, sum(constract_detail.quantity) as sum
		from constract_detail
		group by constract_detail.additional_service_ID) 
        abc;




---- Thử nghiệm phương án tương tự
SELECT 
    addtional_service.additional_service_ID,
    addtional_service.additional_service_name,
    SUM(constract_detail.quantity) AS service_amount
FROM
    addtional_service
        JOIN
    constract_detail ON addtional_service.additional_service_ID = constract_detail.additional_service_ID
GROUP BY addtional_service.additional_service_ID
HAVING service_amount = (SELECT 
        MAX(result.sum)
    FROM
        constract_detail
            JOIN
        (SELECT 
            SUM(constract_detail.quantity) AS sum,
                constract_detail.additional_service_ID AS code
        FROM
            constract_detail
        GROUP BY constract_detail.additional_service_ID) result ON constract_detail.constract_detail_ID = result.code);

-- Câu 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

SELECT 
    constract.constract_ID,
    service_type.service_type_name,
    addtional_service.additional_service_name,
    COUNT(addtional_service.additional_service_ID) AS service_amount
FROM
    addtional_service
        JOIN
    constract_detail ON addtional_service.additional_service_ID = constract_detail.additional_service_ID
        JOIN
    constract ON constract_detail.constract_ID = constract.constract_ID
        JOIN
    service ON constract.service_ID = service.service_ID
        JOIN
    service_type ON service.service_type_ID = service_type.service_type_ID
WHERE
    addtional_service.additional_service_ID IN (SELECT 
            addtional_service.additional_service_ID
        FROM
            addtional_service
                JOIN
            constract_detail ON addtional_service.additional_service_ID = constract_detail.additional_service_ID
        GROUP BY addtional_service.additional_service_ID
        HAVING COUNT(constract_detail.constract_detail_ID) = 1)
GROUP BY constract_detail.constract_detail_ID;


-- Cau 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

 Create view constract_amount_of_employee as
select employee.employee_ID, count(constract.employee_ID) as constract_count
from employee
join constract on employee.employee_ID = constract.employee_ID
group by employee.employee_ID;

SELECT 
    employee.employee_ID,
    employee.employee_name,
    employee_level.level_name,
    department.department_name,
    employee.phone_number,
    employee.address,
    constract_amount_of_employee.constract_count as times
FROM
    employee
    join
     employee_level on employee.level_ID = employee_level.level_ID
     join department on employee.department_ID = department.department_ID
     join constract_amount_of_employee on  employee.employee_ID=constract_amount_of_employee.employee_ID
     where constract_amount_of_employee.constract_count <= 3;

-- Cau 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

set sql_safe_updates = 0;
delete from employee
where employee.employee_ID in (
select employee.employee_ID, count(constract.constract_ID)
from employee
left join constract on employee.employee_ID = constract.employee_ID
group by employee.employee_ID
having count(constract.constract_ID) = 0);

set sql_safe_updates = 0;
DELETE e FROM employee e
        LEFT JOIN
    constract ON e.employee_ID = constract.employee_ID 
WHERE
    constract.constract_ID IS NULL;
    set sql_safe_updates = 1;


-- Câu 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

create view total_contract as
select constract.customer_ID, 
		service.rent_fee + constract_detail.quantity*addtional_service.additional_service_price as total
from constract
join service on constract.service_ID = service.service_ID
left join constract_detail on constract.constract_ID = constract_detail.constract_ID
join addtional_service on constract_detail.additional_service_ID = addtional_service.additional_service_ID;


update customer
join customer_type on customer.customer_type_ID = customer_type.customer_type_ID
join (
select customer_ID, sum(total)
from total_contract
group by customer_ID
having sum(total) > 10000000) customer_money
on customer.customer_ID = customer_money.customer_ID
set customer.customer_type_ID = 1
where customer.customer_type_ID = 2;


-- Câu 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

SET FOREIGN_KEY_CHECKS=0;

delete c from customer c
join constract on c.customer_ID = constract.customer_ID
where year(constract.begin_date) < 2021;
SET FOREIGN_KEY_CHECKS=1;


-- Câu 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
set sql_safe_updates = 0;
UPDATE addtional_service
        JOIN
    (SELECT 
        constract_detail.additional_service_ID AS add_service_ID,
            SUM(constract_detail.quantity)
    FROM
        constract_detail
    JOIN constract ON constract_detail.constract_ID = constract.constract_ID
    WHERE
        YEAR(constract.begin_date) = 2020
    GROUP BY constract_detail.additional_service_ID
    HAVING SUM(constract_detail.quantity) > 10) constract_amount ON addtional_service.additional_service_ID = constract_amount.add_service_ID 
SET 
    addtional_service.additional_service_price = addtional_service.additional_service_price * 2;
set sql_safe_updates = 1;

-- Câu 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống,
--  thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.

SELECT 
    e.employee_ID AS id,
    e.employee_name AS name,
    e.email,
    e.phone_number,
    e.employee_birthday AS birth_day,
    e.address
FROM
    employee e 
UNION ALL SELECT 
    c.customer_ID,
    c.customer_name,
    c.email,
    c.phone_number,
    c.customer_birthday,
    c.address
FROM
    customer c;


-- Câu 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu”
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

create view v_employee as

select e.employee_ID, e.employee_name, e.employee_birthday, e.address
from employee e
join constract on e.employee_ID = constract.employee_ID
where constract.begin_date = '2019-12-12' and e.address like '%Hải Châu%';

-- Câu 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.

set sql_safe_updates = 0;
update v_employee
set address = 'Liên Chiểu';
set sql_safe_updates = 1;


-- Câu 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó 
-- với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

delimiter //
create procedure sp_delete_customer  (in customer_id int)
begin
	delete c from customer c
    where c.customer_id = customer_id;
end //
delimiter ;

call sp_delete_customer (11);

-- Câu 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong 
-- với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
create procedure sp_add_constract (
	in constract_id int, 
    in begin_date date, 
    in end_date date, 
    in deposite_money double, 
    in employee_ID int, 
    in customer_ID int, 
    in service_ID int)
begin
	if constract_id not in ( 
								select constract.constract_ID
                                from constract )
		           
   		and  employee_ID in ( 
								select employee.employee_ID
                                from employee )                     
   		and customer_ID in ( 
								select customer.customer_ID
                                from customer )
		and service_ID in ( 
								select service.service_ID
                                from service ) 
	then 
    select *
    from constract ;
    insert into constract
    values (
		constract_id,
		begin_date,
		end_date,
        deposite_money,
		employee_ID,
		customer_ID,
		service_ID);
       end if;
end //
delimiter ;

call sp_add_constract (
						14,
                        '2022-03-15',
                        '2022-03-18',
                        0,
                        11,
                        10,
                        2);

-- Câu 25.	Tạo Trigger có tên tr_xoa_hop_dong 
-- khi xóa bản ghi trong bảng hop_dong 
-- thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.

delimiter //
create trigger tr_after_delete_constract
after delete
on constract 
for each row
begin
	select count(*) into @amount
    from constract;

end //
delimiter ;

set @amount = 0;
delete from constract 
    where constract_ID = 14;

select @amount as constract_quantity;

select *
    from constract;
    
    drop trigger tr_after_delete_constract;








-- Câu 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, 
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database

delimiter //
create trigger before_update_constract
before update 
on constract 
for each row
begin
	declare error_message varchar(255);
    set error_message = 'End_date of constract must be later begin_date at least 2 days';
	if datediff(new.begin_date, new.end_date) <2
		then signal SQLSTATE '45000'
			set message_text = error_message;
			end if;
            
end //
delimiter ;
	
update constract
set end_date = '2022-03-16'
where constract_ID = 14;

-- Câu 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: 
-- Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ 
-- (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
-- Mã của khách hàng được truyền vào như là 1 tham số của function này.













