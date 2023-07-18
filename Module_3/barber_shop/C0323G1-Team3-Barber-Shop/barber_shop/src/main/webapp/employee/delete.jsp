<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/9/2023
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Xóa Nhân viên</title>
</head>
<body>
<form action="/EmployeeServlet?action=delete&id=${employee.getEmployeeId()}" method="post">
    <fieldset>
        <legend>Thông tin nhân viên cần xóa</legend>
        <table>
            <tr>
                <td>Họ và tên</td>
                <td><c:out value="${employee.getEmployeeName()}"/></td>
            </tr>
            <tr>
                <td>Ngày sinh</td>
                <td><c:out value="${employee.getBirthDay()}" /></td>
            </tr>
            <tr>
                <td>Lương</td>
                <td><c:out value="${employee.getSalary()}" /></td>
            </tr>
            <tr>
                <td>Số điện thoại</td>
                <td><c:out value="${employee.getPhoneNumber()}" /></td>
            </tr>
            <tr>
                <td>Giới tính</td>
                <td><c:out value="${employee.isGender()}" /></td>
            </tr>
            <tr>
                <td>Số CMND/CCCD</td>
                <td><c:out value="${employee.getIdCard()}" /></td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td><c:out value="${employee.getAddress()}" /></td>
            </tr>
                <td><input type="submit" value="Xóa Nhân viên"/></td>
                <td><a href="/EmployeeServlet" ><button type="button">Hủy</button></a></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>
