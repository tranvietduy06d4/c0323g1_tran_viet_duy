<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/19/2023
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result of Sandwich Condiment</h1>

<p>Sandwich Condiment includes: </p>
<p>
<c:forEach var="condiment" items="${listCondiment}">
    <c:if test="${condiment != null}" >${condiment}</c:if>
</c:forEach>
</p>
</body>
</html>
