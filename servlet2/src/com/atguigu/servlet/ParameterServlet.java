package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 //获取请求的参数，用name属性的值来作为参数获取
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
//获取有多个参数的请求
String []hobby=req.getParameterValues("hobby");
System.out.println(Arrays.toString(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        req.setCharacterEncoding("UTF-8");
        System.out.println("=-----post----");
        //获取请求的参数，用name属性的值来作为参数获取
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
//获取有多个参数的请求
        String []hobby=req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobby));
    }
}
