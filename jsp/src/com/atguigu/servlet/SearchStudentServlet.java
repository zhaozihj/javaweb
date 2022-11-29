package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        //发sql语句查询学生的信息
        //使用for循环代替前面两步
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        for(int i=0;i<10;i++){
            int t=i+1;
            studentArrayList.add(new Student(t,"name",18+t,"phone"+t));
        }
        //保存查询到的结果到request域中
        req.setAttribute("stuList",studentArrayList);
        //请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/test2.jsp").forward(req,resp);
    }
}
