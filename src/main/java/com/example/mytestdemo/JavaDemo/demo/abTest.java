package com.example.mytestdemo.JavaDemo.demo;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.GetReflectDemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/1/22 8:09 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class abTest {
    public static void main(String[] args) {
        A a=new A();
        a.setAge(23);
        B b=new B();
        b.setName("ss");

        String demo="zcyxb_";
        String s="zcyxb_sunjie";
        String m=s.substring(0,6);

        Integer total=57;
        Integer pagesize=20;
        Integer page=1;
       // System.out.println("一共有几页:"+(total/pagesize+"'页'，最后一页"+total%pagesize+"条数据"));

        //b.setMessage("aa");
        //System.out.println(m.equals(GetReflectDemo));

        Integer aa =1;
        String bb ="";
        bb=((aa == 2)?"123":"456");
        System.out.println(bb);
    }
}