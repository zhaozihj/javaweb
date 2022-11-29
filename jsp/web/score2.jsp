<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/1
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>score2</h1>
<body>
pageContext域是否有值：<%=pageContext.getAttribute("key")%> <br>
request域是否有值：<%=request.getAttribute("key")%> <br>
session域是否有值：<%=session.getAttribute("key")%> <br>
application域是否有值：<%=application.getAttribute("key")%> <br>

</body>
</html>
