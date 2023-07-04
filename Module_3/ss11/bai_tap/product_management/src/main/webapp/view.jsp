<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/3/2023
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hiển thị thông tin sản phẩm</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>Tên sản phẩm</td>
        <td>Giá sản phẩm</td>
        <td>Mô tả sản phẩm</td>
        <td>Nhà sản xuất</td>
    </tr>
    <tr>
        <td><c:out value="${product.getName()}"/></td>
        <td><c:out value="${product.getPrice()}"/></td>
        <td><c:out value="${product.getDescription()}"/></td>
        <td><c:out value="${product.getProducer()}"/></td>
    </tr>
</table>

</body>
</html>
