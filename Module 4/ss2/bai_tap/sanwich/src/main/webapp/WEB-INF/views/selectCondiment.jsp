<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/19/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Condiment Form</title>
</head>
<body>
<h1>Select Condiment Form</h1>
<form action="/create" method="post">
  <input type="checkbox" name="condiment" value="lettuce">Lettuce
  <input type="checkbox" name="condiment" value="tomato">Tomato
  <input type="checkbox" name="condiment" value="mustard">Mustard
  <input type="checkbox" name="condiment" value="sprout">Sprout
  <button>Submit</button>
</form>
</body>
</html>
