<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/3/2023
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/ProductServlet?action=showFormCreate">Thêm mới sản phẩm</a>
<c:if test="${msg!=null}">
  <c:out value="${msg}"/>
</c:if>
<table border="1px">
  <tr>
    <th>STT</th>
    <th>Tên sản phẩm</th>
    <th>Giá sản phẩm</th>
    <th>Mô tả sản phẩm</th>
    <th>Nhà sản xuất</th>
    <th>Cập nhật</th>
    <th>Xóa</th>
  </tr>
  <c:forEach var="product" items="${list}" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td><c:out value="${product.getName()}"/></td>
      <td><c:out value="${product.getPrice()}"/></td>
      <td><c:out value="${product.getDescription()}"/></td>
      <td><c:out value="${product.getProducer()}"/></td>
      <td><a href="/ProductServlet?action=showFormEdit&id=${product.getId()}">Cập nhật</a></td>
      <td><a href="/ProductServlet?action=showFormDelete&id=${product.getId()}">Xóa</a></td>
    </tr>

  </c:forEach>

</table>

</body>
</html>
