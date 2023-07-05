<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/4/2023
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UserServlet">Quay về danh sách các Users</a>
<form action="/UserServlet?action=edit&id=${user.getId()}" method="post">
    <fieldset>
        <legend>Thông tin User</legend>
        <table>
            <tr>
                <td>Tên User</td>
                <td><input type="text" value="${user.getName()}" name="name"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" value="${user.getEmail()}"name="email"></td>
            </tr>
            <tr>
                <td>Quốc gia</td>
                <td><input type="text" value="${user.getCountry()}"name="country"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="Cập nhật User"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
