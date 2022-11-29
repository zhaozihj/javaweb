<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/10
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println("a.jsp页面执行了");
    Object user=session.getAttribute("user");
    //如果等于null，说明还没有登陆
    if(user==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
    }
%>
</body>
</html>
