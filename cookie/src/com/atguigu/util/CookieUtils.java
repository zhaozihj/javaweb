package com.atguigu.util;

import javax.servlet.http.Cookie;

/*
查找指定名称的cookie对象
 */
public class CookieUtils {
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
