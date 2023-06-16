use quan_ly_ban_hang;

--- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select *
from `order`;

--- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

select cName, order_detail.odQuantity, product.pName
from customer
join `order` on customer.cID = `order`.cID
join order_detail on `order`.oID = order_detail.oID
join product on order_detail.pID = product.pID;

--- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select cName, `order`.oID
from customer
left join `order` on customer.cID = `order`.cID
where oID = 'null';


select * from customer;

select * from `order`;