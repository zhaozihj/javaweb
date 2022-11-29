<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/2
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息<br/>
主体信息<br/>


<%@ include file="/include/foot.jsp"%>

<%--可以向foot.jsp传递参数，在foot.jsp页面中获取，因为都是用的一个request对象--%>
<jsp:include page="/include/foot.jsp">
   <jsp:param name="username" value="admin"/>
   <jsp:param name="password" value="admin"/>
</jsp:include>

<%--请求转发--%>
<jsp:forward page="/score2.jsp"></jsp:forward>
</body>
</html>
