package com.example.mytestdemo.demo;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.demo
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


        //b.setMessage("aa");
        System.out.println(m.equals(demo));
    }
}