<%--
  Created by IntelliJ IDEA.
  User: tranv
  Date: 7/19/2023
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
  <fieldset>
    <table>
      <tr>
        <td>Number 1</td>
        <td><input type="number" name="firstNumber" value="firstNumber" required></td>
      </tr>
      <tr>
        <td>Number 2</td>
        <td><input type="number" name="secondNumber" value="secondNumber" required></td>
      </tr>
    </table>
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(*)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
  </fieldset>
</form>
</body>
</html>
