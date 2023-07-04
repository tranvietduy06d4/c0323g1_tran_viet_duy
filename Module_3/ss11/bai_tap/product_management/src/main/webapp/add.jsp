<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/3/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/ProductServlet">Quay về danh sách sản phẩm</a>
<form action="/ProductServlet?action=create" method="post">
  <table>
    <tr>
      <td>Mã sản phẩm</td>
      <td><input type="number" name="id"></td>
    </tr>
    <tr>
      <td>Tên sản phẩm</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Giá sản phẩm</td>
      <td><input type="number" name="price"></td>
    </tr>
    <tr>
      <td>Mô tả sản phẩm</td>
      <td><input type="text" name="description"></td>
    </tr>
    <tr>
      <td>Nhà sản xuất</td>
      <td><input type="text" name="producer"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Tạo mới"></td>
    </tr>
  </table>
</form>

</body>
</html>
