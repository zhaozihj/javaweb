<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/8
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8079/cookie/LoginServlet" method="get">
  用户名:  <input type="text" name="username" value="${cookie.username.value}"><br>
    密码:  <input type="password" name="password"><br>
          <input type="submit" value="登录">
</form>
</body>
</html>
