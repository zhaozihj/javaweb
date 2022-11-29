<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/2
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border:1px black solid;
            width:600px;
            border-collapse: collapse;

        }
        td,th{
   border:1px black solid;
        }
    </style>
</head>
<body>
<%
    List<Student> studentList=(List<Student>)request.getAttribute("stuList");
%>
<table border="1px">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>手机号</td>
    </tr>
    <%for(int i=0;i<10;i++){
    int id=studentList.get(i).getId();
    String name=studentList.get(i).getName();
    int age=studentList.get(i).getAge();
    String phone=studentList.get(i).getPhone();
    %>
        <tr>
            <td><%=id%></td>
            <td><%=name%></td>
            <td><%=age%></td>
            <td><%=phone%></td>
        </tr>
    <%}%>
</table>
<%

%>
</body>
</html>
