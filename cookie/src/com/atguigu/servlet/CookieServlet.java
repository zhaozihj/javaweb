package com.atguigu.servlet;

import com.atguigu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie cookie=new Cookie("key1","value1");
        //2.通知客户端保存cookie
        resp.addCookie(cookie);

        //1.创建cookie对象
        Cookie cookie1=new Cookie("key2","value2");
        //2.通知客户端保存cookie
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功");


    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getName方法返回cookie的名称
            resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
        }

Cookie iWantCookie= CookieUtils.findCookie("key1",cookies);
        if(iWantCookie!=null){
            resp.getWriter().write("找到了需要的cookie");
        }

       // for (Cookie cookie : cookies) {
            //getName方法返回cookie的名称
           // resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
           // if("key1".equals(cookie.getName())){
               // iWantCookie=cookie;
              //  break;
           // }
        //}
        //如果不等于null,说明附过值，也就是找到了需要的cookie
       // if(iWantCookie!=null){
          //  resp.getWriter().write("找到了需要的cookie");
       //}

    }


    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、先查找到需要修改的 Cookie 对象
        Cookie cookie=CookieUtils.findCookie("key1",req.getCookies());
              //2、调用 setValue()方法赋于新的 Cookie 值。
              cookie.setValue("new1Value");
             //3、调用 response.addCookie()通知客户端保存修改
              resp.addCookie(cookie);
    }

    /**
     * 默认级别的cookie会话，设置为-1是浏览器关闭才消失
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    /*
    立即删除
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //先找到你要删除的cookie对象
        Cookie cookie=CookieUtils.findCookie("key1",req.getCookies());
    //调用setMaxAge(0);
        if(cookie!=null){
            //马上删除
            cookie.setMaxAge(0);

        }
        //response.addCookie(cookie);
        resp.addCookie(cookie);
        resp.getWriter().write("key1的cookie已经被删除");
    }

    /*
    指定cookie再存货一段时间

     */

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("life3600","life3600");
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存货一小时的cookie");

    }

    /*
    带路径的cookie的测试
     */
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          Cookie cookie=new Cookie("path","path");
          //getContextPath()==>>得到工程路径
          cookie.setPath(req.getContextPath()+"/abc");
          System.out.println(req.getContextPath()+"/abc");
          resp.addCookie(cookie);
          resp.getWriter().write("创建了一个带有Path路径的cookie");
    }
}