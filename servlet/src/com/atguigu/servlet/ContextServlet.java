package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context.param
        ServletContext context= getServletConfig().getServletContext();
        String username=context.getInitParameter("username");
        System.out.println("context-param参数username是"+username);
        System.out.println("context-param参数password是"+context.getInitParameter("password"));
        //2.获取当前的工程路径，格式:/工程路径
System.out.println("当前工程的路径"+context.getContextPath());
        //3.获取工程部署后在服务器硬盘上的绝对路径
        //   斜杠   被服务器解析地址为http://ip:port/工程名/    映射到IDEA代码的web目录
        //就是得到的这个地址访问之后就是web目录下的东西
        System.out.println("工程部书之后的路径"+context.getRealPath("/"));
        //获取web目录下的其他文件的绝对路径
        System.out.println("工程下css目录的绝对路径是"+context.getRealPath("/css"));
        System.out.println("工程目录下imgs目录1.jpg的绝对路径是"+context.getRealPath("/imgs/1.jpg"));
    }
}
