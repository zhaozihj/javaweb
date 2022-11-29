package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //解决响应乱码问题
        String parameter=req.getParameter("action");
        try {
            //通过反射获取对应的方法，因为设定获取的action的参数值和调用方法的名字相同
            //this是指调用该post方法的对象
            Method parameter1 = this.getClass().getDeclaredMethod(parameter,HttpServletRequest.class,HttpServletResponse.class);
            //执行目标业务方法
            parameter1.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
