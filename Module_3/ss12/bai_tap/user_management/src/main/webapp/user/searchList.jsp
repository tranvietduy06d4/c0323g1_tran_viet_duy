<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/4/2023
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển thị danh sách tìm kiếm Users</title>
</head>
<body>
<table>
  <tr>
    <th>STT</th>
    <th>Họ và tên</th>
    <th>Email</th>
    <th>Quốc gia</th>
  </tr>
  <c:forEach var="user" items="$userList}" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td>${user.getName()}</td>
      <td>${user.getEmail()}</td>
      <td>${user.getCountry()}</td>
    </tr>
  </c:forEach>
  <tr>
    <td></td>
    <td><a href="/UserServlet">Quay lại danh sách các Users</a></td>
  </tr>
</table>
</body>
</html>
