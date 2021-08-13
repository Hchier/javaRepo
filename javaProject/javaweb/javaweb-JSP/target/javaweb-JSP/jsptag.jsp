<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/9
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsptag</title>
</head>
<body>


<jsp:include page="jspheader.jsp"></jsp:include>
<h1> jsp include</h1>
<jsp:include page="jspfooter.jsp"></jsp:include>

<!--转发到另一个jsp页面-->
<!--    携带参数转到/hello hello页面通过 req.getParameter("username") 拿到参数-->
<jsp:forward page="/hello">
    <jsp:param name="username" value="Hchier"/>
</jsp:forward>

<%--<jsp:forward page="/hello">--%>
<%--    <jsp:param name="username" value="Hchier"/>--%>
<%--</jsp:forward>--%>

</body>
</html>
