package com.atguigu.axios;

import com.atguigu.pojo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/axios02.do")
public class Axios02Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



       //服务器获取参数值，不再是req.getParameter
       //而是
        StringBuffer stringBuffer=new StringBuffer("");
        BufferedReader bufferedReader=req.getReader();
        String str=null;
        while((str=bufferedReader.readLine())!=null){
            stringBuffer.append(str);
        }
        str=stringBuffer.toString();

        //str内容   {"uname":"lina","pwd":"ok"}
        System.out.println(str);


        //已知String需要转化成JavaObject

        //Gson有两个API，1.fromJson（String，T）将字符串转化成java object
        //2.toJson（java Object） 将java Object转化成json字符串，这样了才能响应给客户端
        Gson gson =new Gson();
        User user=gson.fromJson(str, User.class);
        System.out.println(user);



    }
}
