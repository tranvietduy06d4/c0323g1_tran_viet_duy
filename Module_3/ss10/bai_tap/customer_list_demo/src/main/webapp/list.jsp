<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 6/30/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <h1>Danh sách khách hàng</h1>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthDay}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><img src="${customer.avatar}" style="width: 20px;height: 20px"></td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
