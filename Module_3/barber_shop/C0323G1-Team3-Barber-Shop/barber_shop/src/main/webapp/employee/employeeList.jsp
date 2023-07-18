<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/1/2023
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<html>
<head>
    <title>Employee List</title>
    <style>
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Danh sách Nhân viên</h1>
<a href="/EmployeeServlet?action=showFormCreate">Thêm mới nhân viên</a>
<table border="1px" class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Lương</th>
        <th>Số điện thoại</th>
        <th>Giới tính</th>
        <th>Số CMND</th>
        <th>Địa chỉ</th>
        <th>Cập nhật</th>
        <th>Xóa</th>
    </tr>
    <c:forEach var="employee" items="${employeeList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${employee.getEmployeeName()}"/></td>
            <td><c:out value="${employee.getBirthDay()}"/></td>
            <td><c:out value="${employee.getSalary()}"/></td>
            <td><c:out value="${employee.getPhoneNumber()}"/></td>
            <td>
                <c:if test="${employee.isGender()==true}">
                    Nam
                </c:if>
                <c:if test="${employee.isGender()==false}">
                    Nữ
                </c:if>
            </td>
            <td><c:out value="${employee.getIdCard()}"/></td>
            <td><c:out value="${employee.getAddress()}"/></td>

            <td><a class="btn btn-primary"href="/EmployeeServlet?action=edit&id=${employee.getEmployeeId()}" role="button">Cập nhật</a></td>
            <td><a class="btn btn-danger" href="/EmployeeServlet?action=delete&id=${employee.getEmployeeId()}" role="button">Xóa</a></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
