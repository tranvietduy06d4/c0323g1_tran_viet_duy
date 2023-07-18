<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/18/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mẫu nhập thông tin só tiền cần chuyển đổi</title>
</head>
<body>
<form action="/calculate" method="post">
    <input type="number" placeholder="Vui lòng nhập vào số tiền USD" name="usd" required>
    <input type="number" placeholder="Vui lòng nhập tỉ giá" name="rate" required>
    <button>Tính toán</button>
</form>
</body>
</html>
