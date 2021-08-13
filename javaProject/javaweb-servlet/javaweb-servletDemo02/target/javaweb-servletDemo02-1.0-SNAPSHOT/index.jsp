<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/5
  Time: 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/logindispatcher" method="get">
    <input type="text" name="username"><br>
    <input type="submit" value="logindispatcher">
</form>

<form action="${pageContext.request.contextPath}/loginredirect" method="get">
    <input type="text" name="username"><br>
    <input type="submit" value="loginredirect">
</form>


</body>
</html>
