<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/2
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //往四个域中都保存了相同的key的数据

    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
    pageContext.setAttribute("key","pageContext");
%>
${key}
</body>
</html>
