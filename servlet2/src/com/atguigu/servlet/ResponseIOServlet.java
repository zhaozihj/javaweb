package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        //此方法一定要在获取流之前时使用才有效
       resp.setContentType("text/html; charset=UTF-8");
       System.out.println(resp.getCharacterEncoding());
        //要求：往客户端回传字符串数据
        PrintWriter writer=resp.getWriter();
        writer.write("我很帅");
    }
}
