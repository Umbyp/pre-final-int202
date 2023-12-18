<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16-Dec-23
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Office</title>
</head>
<body>
    <c:forEach items="${requestScope.officeList}" var="office">
        <div style="border: 1px solid black; margin: 10px; padding: 10px;">
            <h1>${office.officeCode}</h1>
            <hr>
            <h2>${office.city}, ${office.country}</h2><br>
            <p>${office.addressLine1}</p><br>
            <p>${office.addressLine2}</p>
        </div>
    </c:forEach>
</body>
</html>
