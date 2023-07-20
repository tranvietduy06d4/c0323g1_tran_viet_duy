<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/20/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form setting</title>
</head>
<body>
<h1>Settings</h1>
<%--public EmailConfig(String language, int pageSize, boolean filter, String signature) {--%>
<%--this.language = language;--%>
<%--this.pageSize = pageSize;--%>
<%--this.filter = filter;--%>
<%--this.signature = signature;--%>
<%--}--%>
<c:if test="${message != null}"><span>${message}</span>
</c:if>
<form:form action="/update" method="post" modelAttribute="emailConfig">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <form:select path="language" items="${language}">
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Page Size</td>
            <td>
                <form:select path="pageSize" items="${pageSize}">

                </form:select>
            </td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td>
                <form:checkbox path="filter" value="true"/>Enable spam filter
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
    </table>
    <button>Update</button>
</form:form>
</body>
</html>
