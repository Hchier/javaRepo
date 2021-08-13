<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/9
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>javabean</title>
</head>
<body>

<%--<%--%>
<%--    User user = new User();--%>
<%--    user.setUsername("");--%>
<%--    user.getUsername();--%>
<%--%>--%>
<%--jspbean的作用同上--%>

<jsp:useBean id="user" class="pojo.User" scope="page"/>
<jsp:setProperty name="user" property="username" value="Hchier"></jsp:setProperty>
<jsp:setProperty name="user" property="password" value="pyh"></jsp:setProperty>
username:<jsp:getProperty name="user" property="username"/>
password:<jsp:getProperty name="user" property="password"/>
</body>
</html>
