<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/12/2022
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1 style="color: crimson">CACULATOR</h1>
<form method="post" action="/caculator">
    <input name="number1" value="" type="text" placeholder="">
    <input name="number2" value="" type="text" placeholder="">
    <input type="submit" value="Addition (+)" name="caculator"/>
    <input type="submit" value="Subtraction (-)" name="caculator"/>
    <input type="submit" value="Multiplication (*)" name="caculator"/>
    <input type="submit" value="Division (/)" name="caculator"/>
<%--    <input type="submit" value="result" name="caculator"/>--%>
</form>
${result}
</body>
</html>
