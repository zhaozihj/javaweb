<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/3
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
i.<c:set />
作用：set 标签可以往域中保存数据

以前保存域数据
域对象.setAttribute(key,value);

scope 属性设置保存到哪个域
page 表示 PageContext 域（默认值）
request 表示 Request 域
session 表示 Session 域
application 表示 ServletContext 域
var 属性设置 key 是多少
value 属性设置值
--%>
保存之前:${requestScope.abc}<br/>
<c:set scope="request" var="abc" value="abcValue"/>
保存之后:${requestScope.abc}<br/>
<%--
ii.<c:if />
if 标签用来做 if 判断。
test 属性表示判断的条件（使用 EL 表达式输出）
--%>
<c:if test="${12==12}">
    <h1>无敌</h1>
</c:if>
<c:if test="${12!=12}">
    <h1>无敌</h1>
</c:if>



<%--
iii.<c:choose> <c:when> <c:otherwise>标签
作用：多路判断。跟 switch ... case .... default 非常接近
choose 标签开始选择判断
when 标签表示每一种判断情况
test 属性表示当前这种判断情况的值
otherwise 标签表示剩下的情况
<hr/>

<c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
1、标签里不能使用 html 注释，要使用 jsp 注释
2、when 标签的父标签一定要是 choose 标签
--%>
<%
    request.setAttribute("height",178);
%>
<c:choose>
    <c:when test="${requestScope.height>190}">
        <h1>是巨人</h1>
    </c:when>
    <c:when test="${requestScope.height>180}">
        <h1>小巨人</h1>
    </c:when>
    <c:when test="${requestScope.height>170}">
        <h1>还行</h1>
    </c:when>
    <c:when test="${requestScope.height>160}">
        <h1>有点矮</h1>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${requestScope.height>150}">
                <h1>xiaoren</h1>
            </c:when>
            <c:when test="${requestScope.height>140}">
                <h1>xiaoren2</h1>
            </c:when>
        </c:choose>
    </c:otherwise>
</c:choose>




</body>
</html>
