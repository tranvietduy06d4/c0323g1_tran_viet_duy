<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/8/2023
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chỉnh sửa thông tin Nhân viên</title>
</head>
<body>
<form action="/EmployeeServlet?action=edit&id=${employee.getEmployeeId()}" method="post">
    <fieldset>
        <legend>Chỉnh sửa thông tin nhân viên</legend>
        <table>
            <tr>
                <td>Họ và tên</td>
                <td><input type="text" value="${employee.getEmployeeName()}" name="name"></td>
            </tr>
            <tr>
                <td>Ngày sinh</td>
                <td><input type="text" value="${employee.getBirthDay()}" name="birthDay"></td>
            </tr>
            <tr>
                <td>Lương</td>
                <td><input type="number" value="${employee.getSalary()}" name="salary"></td>
            </tr>
            <tr>
                <td>Số điện thoại</td>
                <td><input type="text" value="${employee.getPhoneNumber()}" name="phoneNumber"></td>
            </tr>
            <tr>
                <td>Giới tính</td>
                <td>
                    <select name="gender" id="gender">
                        <option value="true">Nam</option>
                        <option value="false">Nữ</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Số CMND/CCCD</td>
                <td><input type="text" value="${employee.getIdCard()}" name="idCard"></td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td><input type="text" value="${employee.getAddress()}" name="address"></td>
            </tr>
            <input type="submit" value="Cập nhật"/>
        </table>
    </fieldset>
</form>

</body>
</html>
