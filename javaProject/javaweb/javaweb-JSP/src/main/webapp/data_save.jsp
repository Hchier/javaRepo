<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/8
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<%
    pageContext.setAttribute("name1","111");//保存的数据只在一个页面中有效
    request.setAttribute("name2","222");//保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3","333");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4","444");//保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>

<%
    String name1 = (String) pageContext.getAttribute("name1");
    String name2 = (String) pageContext.getAttribute("name2");
    String name3 = (String) pageContext.getAttribute("name3");
    String name4 = (String) pageContext.getAttribute("name4");
    String name5 = (String) pageContext.getAttribute("name5");
%>

<h4>${name1}</h4>
<h4>${name2}</h4>
<h4>${name3}</h4>
<h4>${name4}</h4>
<!--用el表达式，为null时不显示。用下面的，为null时显示null-->
<h4><%=name5%></h4>
</body>
</html>
