<%@ page import="vn.codegym.model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/11/2022
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="vn.codegym.service.CustomerService" %>
<%@ page import="vn.codegym.service.CustomerServiceFactory" %>
<%@ page import="vn.codegym.model.Customer" %>
<%@ page import="java.util.List" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>
<html>
<head>
    <title>Title</title>
    <style>
    table {
    border: 1px solid #000;
    }
    th, td {
    border: 1px dotted #555;
    }
    </style>

</head>
<body>
There are <%= count %> customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <% for (Customer c : customers) { %>
    <tr>
        <td>
            <%= c.getId() %>
        </td>
        <td>
            <a href="info.jsp?id=<%= c.getId() %>"><%= c.getName() %></a>
        </td>
        <td>
            <%= c.getEmail() %>
        </td>
        <td>
            <%= c.getAddress() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
