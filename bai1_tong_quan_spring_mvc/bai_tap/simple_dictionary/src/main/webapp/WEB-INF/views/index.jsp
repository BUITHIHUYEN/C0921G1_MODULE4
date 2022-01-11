<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/10/2022
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Dictionary</title>
  </head>
  <body>
  <h1>Vietnamese Dictionary</h1>
  <form method="post" >
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  <p>RESULT :${result}</p>
  </body>
</html>
