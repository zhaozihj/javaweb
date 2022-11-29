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

        //解决post请求中文乱码问题
        //一定要在获取请求参数之前调用才有效
        //req.setCharacterEncoding("UTF-8");
        //解决响应的中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
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
