<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/20/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email config info</title>
</head>
<body>
<table>
    <tr>
        <td>Language</td>
        <td>${email.language}</td>
    </tr>
    <tr>
        <td>Spam Filter</td>
        <td>${email.filter}</td>
    </tr>
    <tr>
        <td>Page Size</td>
        <td>${email.pageSize}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${email.signature}</td>
    </tr>
</table>
<a href="/update">Update</a>
</body>
</html>
