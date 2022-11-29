<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/2
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
jsp的用法
<%
    request.setAttribute("key","值");
%>
表达式输出key的值是<%=request.getAttribute("key1")%>

EL表达式输出key的值
${key1}
</body>
</html>
