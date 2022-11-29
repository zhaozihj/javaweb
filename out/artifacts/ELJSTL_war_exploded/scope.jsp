<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/2
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key1","pageContext1");
    pageContext.setAttribute("key2","pageContext2");
    request.setAttribute("key2","request");
    session.setAttribute("key2","session");
    application.setAttribute("key2","application");

%>
<%--输出pageContext域中的属性--%>
<%--如果多个域中只有一个key1，可以直接${key1}   但是如果两个域中都由key1属性，就可以通过${内置对象.key1}来调用你想要的--%>
${pageScope.key1}<br/>
${pageScope.key2}<br/>
${requestScope.key2}<br/>
${sessionScope.key2}<br/>
${applicationScope.key2};<br/>

</body>
</html>
