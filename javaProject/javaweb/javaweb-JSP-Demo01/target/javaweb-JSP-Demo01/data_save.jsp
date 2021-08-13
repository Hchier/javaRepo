<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/19
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>data_save</title>
</head>
<body>
<%

    pageContext.setAttribute("name1","111");//保存的数据只在一个页面中有效
    request.setAttribute("name2", "2");
    session.setAttribute("name3", "3");
    application.setAttribute("name4", "4");
%>
<%

    String name11 = (String) pageContext.getAttribute("name1");
    String name2 = (String)pageContext.getAttribute("name2");
    String name3 = (String)pageContext.getAttribute("name3");
    String name4 = (String)pageContext.getAttribute("name4");
%>

${name1} <br>
${name2} <br>
${name3} <br>
${name4} <br>

</body>
</html>
