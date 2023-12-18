<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16-Dec-23
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form method="post" action="${pageContext.request.contextPath}/040/login">
        <label>
            Username :
            <input type="text" name="userName" placeholder="username" required>
        </label>
        <br>
        <label>
            Password :
            <input type="password" name="password" placeholder="password" required>
        </label>
        <br>
        <c:if test="${requestScope.error != null}">
            <p>${requestScope.error}</p>
        </c:if>
        <input type="submit" value="confirm">
    </form>
</body>
</html>
