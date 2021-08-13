<%--
  Created by IntelliJ IDEA.
  User: Hchier
  Date: 2021/7/8
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>jsp</title>
</head>
<body>
<%--jsp表达式--%>
<%= new java.util.Date()%>


<%--jsp脚本片段--%>
<%
    int sum=0;
    for(int i=1;i<101;i++){
        sum+=i;
    }
    out.println("<h1>sum="+sum+"</h1>");
%>


<%--jsp声明，类中，非方法中--%>
<%!
    static {
        System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void kuang(){
        System.out.println("进入了方法Kuang！");
    }
%>


</body>
</html>
