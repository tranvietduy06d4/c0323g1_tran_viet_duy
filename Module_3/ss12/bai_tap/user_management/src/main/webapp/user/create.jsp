<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/4/2023
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm mới User</title>
</head>
<body>
<a href="/UserServlet">Quay trở về danh sách Users</a>
<form action="/UserServlet?action=create" method="post">
    <fieldset>
        <legend>Thông tin User cần thêm mới</legend>
        <table>
            <tr>
                <td>Mã số ID</td>
                <td><input type="number" name="id"></td>
            </tr>
            <tr>
                <td>Họ và tên</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Quốc gia</td>
                <td><input type="text" name="country"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Thêm mới user"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
