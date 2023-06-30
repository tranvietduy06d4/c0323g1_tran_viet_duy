<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculate</title>
</head>
<body>
<form method="post" action="CalculatorServlet">
    <h1>Simple Calculator</h1>
    <h2>Calculator</h2>
    <table>
        <tr>
            <td>First Operand:</td>
            <td><input type="text" name="first-operand"></td>
        </tr>
        <tr>
            <td>Operator:</td>
            <td>
                <select name="operator">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second Operand:</td>
            <td><input type="text" name="second-operand"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Calculate"></td>
        </tr>
    </table>

</form>
</body>
</html>