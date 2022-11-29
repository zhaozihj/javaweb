package com.atguigu.axios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/axios01.do")
public class Axios01Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码
        req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("usname:"+uname);
        System.out.println("pwd:"+pwd);

        //设置相应编码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //设置响应数据
        PrintWriter out=resp.getWriter();
        out.write(uname+"_"+pwd);

        //故意抛出空指针异常
        throw new NullPointerException();
    }
}
