<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/3/2023
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật thông tin sản phẩm</title>
</head>
<body>
<form action="/ProductServlet?action=edit" method="post">
    <fieldset>
        <legend>Thông tin sản phẩm</legend>
        <table>
            <tr>
                <td>Tên sản phẩm</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm</td>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td>Mô tả sản phẩm</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất</td>
                <td><input type="text" name="producer"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="Cập nhật sản phẩm"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
