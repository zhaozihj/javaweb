<%--
  Created by IntelliJ IDEA.
  User: #赵梓皓&
  Date: 2022/10/1
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="utf-8"
         import="java.util.Map"
         autoFlush="true"
         buffer="8kb"
         errorPage="/error500.jsp"
         language="java" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--1.声明类属性-->
<%!
    private Integer id;
    private String name;
    private static Map<String,Object> map;
%>
<!--2.定义静态代码块-->
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }
%>

<!--声明类的方法-->
<%!
    public int abc(){
        return 12;
    }
%>

<!--生成内部类-->
<%!
    public static class A{
        private Integer id;
        private String abc="abc";

    }
%>

<%=12%><br/>
<%=12.12%><br/>
<%="我是字符串"%><br/>
<%=map%>
<!--使用_jspService方法中的对象-->
<%=request.getParameter("username")%>

<!--代码脚本和表达式脚本组合在一起用-->
<%
    int i=13;
    if(i==12){%>
<h1>我是赵梓皓</h1>
   <% }
    else
    {%>
<h1>我是张几名</h1>
    <%
    }
 %>

<!--两个代码脚本合成一个，即使会报错，但是运行之后还是可以输出的-->
<!--代码脚本还可以和表达式脚本一起组合输出-->
<table border="1" cellspacing="0">

<%
    for(int j=0;j<10;j++){
    %>
    <tr>
        <td><%=j%></td>
    </tr>
    <%
    }
%>

</table>



<!--用jspService中的对象-->
<%
    String username=request.getParameter("username");
    System.out.println("用户名的请求参数是"+username);

%>



</body>
</html>
