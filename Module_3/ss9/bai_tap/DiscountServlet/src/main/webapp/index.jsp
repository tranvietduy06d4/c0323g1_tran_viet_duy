<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Caculate Discount</title>
</head>
<body>
<form method="post" action="DiscountServlet">
    <label for="product_description">Product Description</label>
    <input type="text" id="product_description" name="product_description">
    <label for="list_price">List Price</label>
    <input type="number" id="list_price" name="list_price">
    <label for="discount_percent">Discount Percent</label>
    <input type="number" id="discount_percent" name="discount_percent">
    <input type="submit" name="discount" value="Calculate Discount">
</form>
</body>
</html>