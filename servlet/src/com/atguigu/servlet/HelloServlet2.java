package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    //重写init程序的时候必须有这个super.init(config)
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);//调用父类的init方法才能让this.config获值
        System.out.println("重写了init初始化方法，做了一些工作");
    }
    /*

    doGet()方法在Get请求的时候调用
    doPost()方法在Post请求的时候调用
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloservlet2  doget");

        //可以使用getServletConfig()方法来获得servletConfig对象
        ServletConfig servletConfig=getServletConfig();
        System.out.println(servletConfig);
        System.out.println("初始化参数username的值为"+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password的值为"+servletConfig.getInitParameter("password"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("helloservlet2 dopost");
    }
}
