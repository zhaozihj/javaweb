<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/1
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>score.jsp页面</h1>
   <%
       //往四个域中都分别保存了数据
       pageContext.setAttribute("key","pageContext");
       request.setAttribute("key","request");
       session.setAttribute("key","session");
       application.setAttribute("key","application");
   %>
   pageContext域是否有值：<%=pageContext.getAttribute("key")%> <br>
   request域是否有值：<%=request.getAttribute("key")%> <br>
   session域是否有值：<%=session.getAttribute("key")%> <br>
   application域是否有值：<%=application.getAttribute("key")%> <br>
<%
    request.getRequestDispatcher("/score2.jsp").forward(request,response);
%>
</body>
</html>
