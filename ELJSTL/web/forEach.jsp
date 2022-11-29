<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/3
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%--4.遍历 List 集合---list 中存放 Student 类，有属性：编号，用户名，密码，年龄，电话信息--%>
<%

    List<Student> studentArraylist = new ArrayList<Student>();
    for(int i=0;i<10;i++)
    studentArraylist.add(new Student(i,i+"username",i+"password",i+18,i+"1"));
    request.setAttribute("list",studentArraylist);
%>

<table>

<tr>
    <td>id</td>
    <td>username</td>
    <td>password</td>
    <td>age</td>
    <td>phone</td>
    <td>step</td>
</tr>
    <%--
    items 表示遍历的集合
    var 表示遍历到的数据
    begin 表示遍历的开始索引值
    end 表示结束的索引值
    step 属性表示遍历的步长值
    varStatus 属性表示当前遍历到的数据的状态
    for（int i = 1; i < 10; i+=2）
    --%>
<c:forEach  begin="2" end="7" step="2" varStatus="status" items="${requestScope.list}" var="stu">
    <tr>
    <td>${stu.id}</td>
    <td>${stu.username}</td>
    <td>${stu.password}</td>
    <td>${stu.age}</td>
    <td>${stu.phone}</td>
    <td>${status.current}</td>
    </tr>
</c:forEach>

</table>

</body>
</html>
