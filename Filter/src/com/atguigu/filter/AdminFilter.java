package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("构造方法调用");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // 1、获取 Filter 的名称 filter-name 的内容
System.out.println("2.Filter的init(FilterConfig filterConfig)初始化");
System.out.println("filter-name的值"+filterConfig.getFilterName());
        //2、获取在 web,xml  Filter 中配置的 init-param 初始化参数
System.out.println("初始化参数username的值"+filterConfig.getInitParameter("username"));
System.out.println("初始化参数url的值"+filterConfig.getInitParameter("url"));
        //3、获取 ServletContext 对象
       System.out.println(filterConfig.getServletContext());
    }

    /*
    doFilter方法，专门用于拦截请求，可以做权限检查
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("这是filter的dofilter方法");
        //获取Session
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
       HttpSession session=httpServletRequest.getSession();
        Object user=session.getAttribute("user");
        //如果等于null，说明还没有登陆
        if(user==null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }
        else
        {
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
            System.out.println("后置代码");
        }
    }

    @Override
    public void destroy() {
System.out.println("filter的destroy方法");
    }


}
