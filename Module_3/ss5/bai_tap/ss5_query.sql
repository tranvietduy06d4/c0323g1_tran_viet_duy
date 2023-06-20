use product_management;

create unique index code_index on products(product_code);
create index composite_index on products(product_name,product_price);

explain select *
		from products
        where products.product_code = 1;

CREATE VIEW product_info AS
    SELECT 
        product_code, product_name, product_price, product_status
    FROM
        products;

set sql_safe_updates = 0;
UPDATE products 
SET 
    product_price = 55000
WHERE
    product_name = 'Kem Merino';
set sql_safe_updates = 1;

DROP VIEW product_info;


DELIMITER //
CREATE PROCEDURE display_all()
BEGIN
    SELECT *
    FROM products;
END //
DELIMITER ;

call display_all();


DELIMITER //
CREATE PROCEDURE add_new_product(
in id int,
in product_code int,
in product_name VARCHAR(255),
in product_price DOUBLE,
in product_amount int,
in product_description VARCHAR(255),
in product_status VARCHAR(255)
)
BEGIN
    INSERT INTO products (id, product_code, product_name, product_price, product_amount, product_description, product_status)
    VALUES (id, product_code, product_name, product_price, product_amount, product_description, product_status);
END //
DELIMITER ;

call add_new_product( 06,06,'Keo mut',50000,5,'Xuat xu Viet Nam','Con han su dung');


DELIMITER //
CREATE PROCEDURE update_product_by_id(
in new_id int,
in new_product_status varchar(255)
)
begin
set sql_safe_updates = 0;
UPDATE products 
SET 
    product_status = new_product_status
WHERE
    id = new_id;
set sql_safe_updates = 1;
END //
DELIMITER ;


call update_product_by_id(3,"Hang nhanh het han, can xu ly som");


DELIMITER //
CREATE PROCEDURE delete_id_product(
in delete_id int
)
begin
set sql_safe_updates = 0;
delete from products
where id = delete_id;
set sql_safe_updates = 1;
END //
DELIMITER ;

call delete_id_product(4);