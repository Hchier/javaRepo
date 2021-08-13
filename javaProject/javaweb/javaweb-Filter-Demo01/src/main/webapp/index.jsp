<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/19
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="get">
    <input type="text" placeholder="username" name="username"><br>
    <input type="password" placeholder="password" name="password"><br>
    <input type="submit">
</form>

</body>
</html>
