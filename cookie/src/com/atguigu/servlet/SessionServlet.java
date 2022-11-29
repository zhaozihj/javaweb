package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{
    /*
    创建和获取Session
     */
    protected void createorGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session=req.getSession();
        //判断当前session会话，是否是新创建出来的
        boolean isNew=session.isNew();
        //获取Session会话的唯一标识
        String id=session.getId();

        resp.getWriter().write("得到的Session的id是"+id+"<br/>");
        resp.getWriter().write("这个Session是否是新创建的"+isNew+"<br/>");
    }
    /*
    往session域中存储数据
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经往session中保存了数据");

    }

    /*
    从session域中获取数据
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute=req.getSession().getAttribute("key1");
        resp.getWriter().write("从session域中获取的key1的值是"+attribute);
    }

    /*
    获取Session的默认存在时长
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取了Session的默认的超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        //
        resp.getWriter().write("Session的默认超时时长为"+maxInactiveInterval+"秒");
    }
    /*
    规定Session3秒之后超时
     */
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取session
        HttpSession session=req.getSession();
        //设置当前session3秒之后消失
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session已经被设置3秒之后超时");

    }
/*
让当前Session立即超时
 */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取session
        HttpSession session=req.getSession();
        //设置当前session3秒之后消失
        session.invalidate();
        resp.getWriter().write("当前Session已经被设置为无效");
    }
}
