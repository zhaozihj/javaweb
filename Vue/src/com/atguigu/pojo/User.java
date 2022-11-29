package com.atguigu.pojo;

public class User {
    private String uname;
    private String pwd;
    public User(){

    }

    public String getUname() {
        return uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
