<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/4
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="get">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
