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

--- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

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


--- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
-- service: service_ID, service_name, service_area, ren_fee
-- service_type: service_type_name

select service.service_ID, service.service_name, service.service_area, service.rent_fee, service_type.service_type_name
from service
left join constract on service.service_ID = constract.service_ID
left join service_type on service.service_type_ID = service_type.service_type_ID
where constract.begin_date >= '2021-01-01' and constract.begin_date <= '2021-03-31' and constract.constract_ID = null;

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021. 



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

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.



