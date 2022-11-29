package com.atguigu.servlet;

import javafx.scene.control.TextInputControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取请求参数，(办事的材料)查看
        //这个参数也可以用get传参直接传
        String username=req.getParameter("username");
        System.out.println("在servlet1柜台中查看参数(材料)"+username);

        //给材料盖一个章，并传递到servlet2柜台二去查看
        req.setAttribute("key","柜台1的章");

        /*
        请求转发必须要以斜杠打头，斜杠表示地址为：http://ip:port/工程名/  ,映射到IDEA代码的web目录，然后在后面加这个servlet文件名即可
         */
        //问路servlet2(柜台二在哪)
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");

        //走向servlet2，柜台二
        requestDispatcher.forward(req,resp);
    }
}
