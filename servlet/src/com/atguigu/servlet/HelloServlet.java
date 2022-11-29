package com.atguigu.servlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.ini方法");
       // 1.可以获取Servlet的别名额就是servlet-name的值
System.out.println("servlet的别名是:"+servletConfig.getServletName());
        //2.获取初始化参数init-param
System.out.println("初始化参数username的值为"+servletConfig.getInitParameter("username"));
System.out.println("初始化参数password的值为"+servletConfig.getInitParameter("password"));
        //3.获取servletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*service方法是专门用来处理请求和响应的*/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //类型转换，HttpServletRequest是ServletRequest的子接口，Servlet没有getMethod方法
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)){
            doGet();
        }
        else if("POST".equals("post请求")){
           doPost();
        }

    }

    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
    }
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy方法");
    }
}