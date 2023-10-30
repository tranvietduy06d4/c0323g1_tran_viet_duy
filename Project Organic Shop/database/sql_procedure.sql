DELIMITER //
CREATE PROCEDURE createOrder(IN user_id BIGINT, IN note TEXT, OUT return_order_id BIGINT)
BEGIN
    -- create a new order
    INSERT INTO orders (code,date_time, flag_deleted, note, user_id )
    VALUES ("",NOW(), 0,note,user_id);

    -- get the ID of the new added order
    SET @order_id = LAST_INSERT_ID();

    -- update the 'code' field with the prefix 'KOL' and the orderId
    UPDATE orders
    SET code = CONCAT('OD', @order_id)
    WHERE id = @order_id;

    -- Create new order details for each item in the cart
    INSERT INTO order_detail (order_id, product_id, quantity, current_price)
    SELECT @order_id, cd.product_id, cd.quantity, p.price
    FROM cart_detail cd
    inner join product p on p.id = cd.product_id
    WHERE cd.user_id = user_id;

    -- update the quantity in the product table
    UPDATE product AS p
    INNER JOIN cart_detail AS cd ON p.id = cd.product_id
    SET p.quantity = p.quantity - cd.quantity
    WHERE cd.user_id = user_id;


    -- delete the items from the cart
    DELETE FROM cart_detail WHERE user_id = user_id;

    -- set the OUT parameter to the order ID
        SET return_order_id = @order_id;

END //
DELIMITER ;

call createOrder(1, "aaa", @return_order_id);