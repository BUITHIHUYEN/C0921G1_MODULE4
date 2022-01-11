<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/11/2022
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body class="wrapper ">
<div class="main-panel">
    <!-- Navbar -->
    <!-- End Navbar -->
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 text-center">
                    <h1>Edit Customer</h1>
                </div>
                <c:if test='${requestScope["message"] != null}'>
                    <span class="col-12 border bg-light">${requestScope["message"]}</span>
                </c:if>
                <form action="/customers" method="post" class="col-12">
                    <div class="form-group col-12">
                        <label class="col-12 float-left mt-1" for="exampleInputPosition">Customer type:</label>
                        <select name="customer_type_id" id="exampleInputPosition" class="form-control col-12">
                            <option selected value="${customer.customerType.customerTypeId}">
                                customer.customerType.customerTypeName
                            </option>
                            <c:forEach items="${customerType}" var="item">
                                <c:choose>
                                    <c:when test="${item.customerTypeId == customer.customerType.customerTypeId}">
                                        <option value="${item.customerTypeId}"
                                                selected> ${item.customerTypeName} </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item.customerTypeId}"> ${item.customerTypeName} </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-12">
                        <label class="col-12 float-left" for="customerId">Customer Id:</label>
                        <input type="text" name="customer_id" class="form-control col-12 mt-2"
                               id="customerId" placeholder="Enter  Customer Id"
                               value="${customer.customerId}">
                    </div>
                    <div class="form-group col-12">
                        <label class="col-12 float-left" for="customerName">Customer Name:</label>
                        <input type="text" name="customer_name" class="form-control col-12 mt-2"
                               id="customerName" placeholder="Enter Customer Name:"
                               value="${customer.customerName}">
                    </div>
                    <div class="form-group col-12">
                        <label class="col-12 float-left" for="customerBirthday">Customer Birthday:</label>
                        <input type="text" name="customer_birthday" class="form-control col-12  mt-2"
                               id="customerBirthday" placeholder="Enter Customer Birthday:"
                               value="${customer.customerBirthday}">
                        <p style="color: red"> ${msgIdCard} </p>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="customerGender">Customer Gender:</label>
                            <select type="number" name="customer_gender" class="form-control col-12  mt-2"
                                    id="customerGender" placeholder="Enter Customer Gender">
                                <c:if test="${customer.customerGender==1}">
                                    <option value="1" selected>Male</option>
                                    <option value="0">Female</option>
                                </c:if>
                                <c:if test="${customer.customerGender==0}">
                                    <option value="1">Male</option>
                                    <option value="0" selected>Female</option>
                                </c:if>
                            </select>
                            <p style="color: red"> ${msgIdCard} </p>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="customerIdCard">Customer Id Card:</label>
                            <input type="text" name="customer_id_card" class="form-control col-12  mt-2"
                                   id="customerIdCard" placeholder="Enter Customer Id Card"
                                   value="${customer.customerIdCard}">
                            <p style="color: red"> ${msgIdCard} </p>
                            <p style="color: red">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="customerPhone">Customer Phone:</label>
                            <input type="text" name="customer_phone" class="form-control col-12  mt-2"
                                   id="customerPhone" placeholder="Enter Customer Phone"
                                   value="${customer.customerPhone}">
                            <p style="color: red"> ${msgIdCard} </p>
                            <p style="color: red">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="customerEmail">Customer Email:</label>
                            <input type="text" name="customer_email" class="form-control col-12  mt-2"
                                   id="customerEmail" placeholder="Enter Customer Email"
                                   value="${customer.customerEmail}">
                            <p style="color: red"> ${msgIdCard} </p>
                            <p style="color: red">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left" for="customerAddress">Customer Address:</label>
                            <input type="text" name="customer_address" class="form-control col-12  mt-2"
                                   id="customerAddress" placeholder="Enter Customer Address"
                                   value="${customer.customerAddress}">
                            <p style="color: red"> ${msgIdCard} </p>
                            <p style="color: red">
                        </div>
                        <button type="submit" name="action" value="edit" class="btn btn-primary float-right">Edit
                        </button>
                        <a href="">
                            <button type="button" class="btn btn-info float-right">Back</button>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%-- Footer --%>
</div>
</div>
</body>
</html>
