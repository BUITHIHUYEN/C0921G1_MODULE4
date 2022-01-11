<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/10/2022
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CURRENCE CONVERTER</title>
</head>
<body>
<h1>Currency Converter</h1>
<form method="post">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="24000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value=""/><br/>
    <input type = "submit" id = "submit" value = "Converter "/>
</form>
<p>RESULT :${result}</p>
</body>
</html>
