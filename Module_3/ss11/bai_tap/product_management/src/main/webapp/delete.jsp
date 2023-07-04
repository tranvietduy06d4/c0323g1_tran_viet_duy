<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/3/2023
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/ProductServlet">Quay về danh sách sản phẩm</a>
<form action="/ProductServlet?action=delete&id=${product.getId()}" method="post">
    <fieldset>
        <legend>Bạn có thực sự muốn xóa sản phẩm dưới đây không? </legend>
        <table>
            <tr>
                <td>Tên sản phẩm</td>
                <td><input type="text" value="${product.getName()}" name="name"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm</td>
                <td><input type="number" value="${product.getPrice()}"name="price"></td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td><input type="text" value="${product.getDescription()}"name="description"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td><input type="text" value="${product.getProducer()}"name="producer"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Xóa sản phẩm"></td>
                <td><a href="/ProductServlet">Quay về danh sách sản phẩm</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
