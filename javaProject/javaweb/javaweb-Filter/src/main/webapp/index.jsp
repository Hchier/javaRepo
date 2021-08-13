<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/9
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
在线人数
<%--<%= this.getServletConfig().getServletContext().getAttribute("onlineNum")%>--%>


<form action="${pageContext.request.contextPath}/filter/login" method="get">
    <input type="text" placeholder="username" name="username"><br>
    <input type="password" placeholder="password" name="password"><br>
    <input type="submit">
</form>



</body>
</html>
