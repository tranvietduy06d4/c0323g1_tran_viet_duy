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
    <title>Danh sách các Users</title>
</head>
<body>
<a href="/UserServlet?action=showFormCreate">Thêm mới User</a>
<a href="/UserServlet?action=sortByName">Sắp xếp theo tên</a>

<table border="1px">
    <h1>Danh sách các User</h1>
    <tr>
        <th>STT</th>
        <th>Họ và tên</th>
        <th>Email</th>
        <th>Quốc gia</th>
        <th>Cập nhật</th>
        <th>Xóa</th>
    </tr>
    <c:forEach var="user" items="${list}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
            <td><a href="/UserServlet?action=showFormEdit&id=${user.getId()}">Cập nhật</a></td>
            <td><a href="/UserServlet?action=delete&id=${user.getId()}">Xóa</a></td>
        </tr>
    </c:forEach>

</table>
<br>
<form action="/UserServlet?action=search" method="post">
    <input type="text" name="searchByCountry"/>
    <input type="submit" value="Tìm kiếm"/>
</form>


</body>
</html>
