<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Pre-Final : INT202 ClassicModels</h1>
<br>
<c:if test="${sessionScope.currentUser != null}">
    <h2>Hello, ${sessionScope.currentUser.contactFirstName} ${sessionScope.currentUser.contactLastName}</h2>
</c:if>
<br/>
<c:if test="${sessionScope.currentUser == null}">
    <a href="040/login">Login</a>
</c:if>
<c:if test="${sessionScope.currentUser != null}">
    <a href="040/login?action=logout">Logout</a>
</c:if>
<br>
<a href="040/office">Office List</a>
</body>
</html>