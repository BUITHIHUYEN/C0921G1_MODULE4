<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/11/2022
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container contact">
    <div class="row">
        <div class="col-md-3">
            <div class="contact-info">
                <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                <h2>Update Customer</h2>
            </div>
        </div>
        <div class="col-md-9" style="padding-top: 5px">
            <form action="/updateCustomer" method="post">
                <div class="contact-form">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="cId">Customer Id:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cId" name="cId" value="${customer.id}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="name">Customer Name:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="email">Email:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="address">Address:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <span><input type="submit" name="action" value="update" class="btn btn-default"></span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
