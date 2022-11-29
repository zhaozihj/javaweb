package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // i. getRequestURI()                             获取请求的资源路径
System.out.println("url=>"+req.getRequestURI());
        //ii. getRequestURL()                            获取请求的统一资源定位符（绝对路径）
System.out.println("ulr=>"+req.getRequestURL());
        //iii. getRemoteHost()                             获取客户端的 ip 地址
System.out.println("客户端 ip 地址"+req.getRemoteHost());
/*
在IDEA中，使用使用localhost访问时，得到的客户端ip地址是127.0.0.1
在IDEA中，使用使用127.0.0.1访问时，得到的客户端ip地址是127.0.0.1
在IDEA中，使用使用真实ip访问时，得到的客户端ip地址是真实ip
 */

        //iv. getHeader()                                      获取请求头
System.out.println("请求头"+req.getHeader("User-Agent"));
        //vii. getMethod()                                    获取请求的方式 GET 或 POST
        System.out.println("请求的方式"+req.getMethod());
    }
}
