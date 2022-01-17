<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/17/2022
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Declaration</title>
</head>
<body>
<h1>Settings</h1>
<a style="margin:auto" href="/create">Back to Setting</a>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Year Of Birth</th>
        <th>Gender</th>
        <th>Nationality</th>
        <th>Identity Card Number</th>
        <th>Travel Information</th>
        <th>Seats</th>
        <th>DepartureDay</th>
        <th>End Date</th>
        <th>Question And Answer 14 Day</th>
        <th>Conscious</th>
        <th>District</th>
        <th>Commune</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Symptom</th>
        <th>Exposure History</th>
    </tr>
    <c:forEach items="${medicalDeclaratons}" var="medicalDeclaratons" varStatus="list">
        <tr>
            <td>${list.count}</td>
            <td>${medicalDeclaratons.name}</td>
            <td>${medicalDeclaratons.yearOfBirth}</td>
            <td>${medicalDeclaratons.gender}</td>
            <td>${medicalDeclaratons.nationality}</td>
            <td>${medicalDeclaratons.identityCardNumber}</td>
            <td>${medicalDeclaratons.travelInformation}</td>
            <td>${medicalDeclaratons.vehicleNumber}</td>
            <td>${medicalDeclaratons.seats}</td>
            <td>${medicalDeclaratons.departureDay}</td>
            <td>${medicalDeclaratons.endDate}</td>
            <td>${medicalDeclaratons.questionAndAnswer14Day}</td>
            <td>${medicalDeclaratons.conscious}</td>
            <td>${medicalDeclaratons.district}</td>
            <td>${medicalDeclaratons.commune}</td>
            <td>${medicalDeclaratons.address}</td>
            <td>${medicalDeclaratons.phone}</td>
            <td>${medicalDeclaratons.email}</td>
            <td>${medicalDeclaratons.symptom}</td>
            <td>${medicalDeclaratons.exposureHistory}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
