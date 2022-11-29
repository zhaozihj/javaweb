<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/2
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
页脚信息<br/>
//获取main.jsp传来的参数
<%=request.getParameter("username")%>
<%=request.getParameter("password")%>
</body>
</html>
