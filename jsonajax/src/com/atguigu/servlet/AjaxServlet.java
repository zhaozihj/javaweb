package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet{
    protected void javascriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Ajax请求过来啦");
      Person person=new Person(1,"国歌");
      //json格式的字符串
        Gson gson=new Gson();
        //服务器响应一个person对象，用json字符串传送
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax===方法调用了");
        Person person = new Person(1, "国歌");
        //json格式的字符串
        Gson gson = new Gson();
        //服务器响应一个person对象，用json字符串传送
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryget===方法调用了");
        Person person = new Person(1, "国歌");
        //json格式的字符串
        Gson gson = new Gson();
        //服务器响应一个person对象，用json字符串传送
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerypost===方法调用了");
        Person person = new Person(1, "国歌");
        //json格式的字符串
        Gson gson = new Gson();
        //服务器响应一个person对象，用json字符串传送
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerygetJson===方法调用了");
        Person person = new Person(1, "国歌");
        //json格式的字符串
        Gson gson = new Gson();
        //服务器响应一个person对象，用json字符串传送
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }


    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySeialize===方法调用了");
        System.out.println("用户名"+req.getParameter("username"));
        System.out.println("密码"+req.getParameter("password"));
        Person person = new Person(1, "国歌");
        //json格式的字符串
        Gson gson = new Gson();
        //服务器响应一个person对象，用json字符串传送
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
