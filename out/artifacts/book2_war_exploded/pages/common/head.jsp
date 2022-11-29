<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/4
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--写base标签，永远固定相对路径的跳转结果-->
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<%--这个最后的/是一定不能省去的--%>
<%--这写个方法的意思写在PageContext演示标题下--%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/script/jquery-1.7.2.js"></script>
