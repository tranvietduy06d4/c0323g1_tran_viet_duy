<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/6/2023
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm mới Nhân viên</title>
</head>
<body>
<form action="/EmployeeServlet?action=create" method="post">
    <fieldset>
        <legend>Thông tin Nhân viên cần thêm mới</legend>
        <table>
            <tr>
                <td>Họ và tên</td>
                <td><input type="text" name="employeeName"></td>
            </tr>
            <tr>
                <td>Ngày sinh</td>
                <td><input type="text" name="birthDay"></td>
            </tr>
            <tr>
                <td>Lương</td>
                <td><input type="number" name="salary"></td>
            </tr>
            <tr>
                <td>Số điện thoại</td>
                <td><input type="text" name="phoneNumber"></td>
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
                <td><input type="text" name="idCard"></td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>Tên đăng nhập</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Mật khẩu đăng nhập</td>
                <td><input type="password" name="password"></td>
            </tr>
            <input type="submit" value="Thêm mới"/>
        </table>

    </fieldset>


</form>

</body>
</html>
