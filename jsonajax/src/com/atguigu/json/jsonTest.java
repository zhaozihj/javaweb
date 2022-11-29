package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.javafx.collections.MappingChange;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;

public class jsonTest {

    //javaBean和json互相转化
    @Test
    public void test1(){
Person person=new Person(1,"好帅");
//创建Gson对象实例
Gson gson=new Gson();
///toJson方法可以把java对象转换成为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        //fromJson把json字符串转换为java对象
        //第一个参数是json字符串，第二个参数是转换回去的java对象类型
        //看好是哪个方法选择第一个参数是字符串的fromJson方法
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    //list集合和json转换
    @Test
    public void test2(){
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"哥"));
        personList.add(new Person(2,"第"));
        Gson gson=new Gson();
        //把List转换为Json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);//[{"id":1,"name":"哥"},{"id":2,"name":"第"}]

        //第二个参数不能是personList.getClass(),这样得到的集合里面存储的是map对象不能转换为Person对象，所以用这个方法
        ArrayList<Person> arrayList = gson.fromJson(personListJsonString, new PersonListType().getType());
        Person person = arrayList.get(0);
        System.out.println(person);

    }

    //map和json的互转
    @Test
    public void test3(){
        Map<Integer,Person>  personMap=new HashMap<>();
        personMap.put(1,new Person(1,"国歌"));
        personMap.put(2,new Person(2,"康师傅"));
        Gson gson=new Gson();
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);//{"1":{"id":1,"name":"国歌"},"2":{"id":2,"name":"康师傅"}}
        Map<Integer,Person> personMap1 = gson.fromJson(personMapJsonString, new
                PersonMapType().getType());
        //使用匿名内部类的方式，这样就不用多创建java的class   TypeToken泛型中是你要返回的类型
      //  Map<Integer,Person> personMap1 = gson.fromJson(personMapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap1);
       Person p=personMap1.get(1);
       System.out.println(p);
    }
}
