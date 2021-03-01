package com.example.mytestdemo.JavaDemo.demo;

import java.util.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.GetReflectDemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/19 6:05 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class hello {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("2");

        List list = Collections.emptyList();
        list.add("");

        A a = new A();
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a.getClass().getClassLoader().getParent());
        System.out.println(a.getClass().getClassLoader().getParent().getParent());

        //返回 JVM 堆大小
        long initalMemory = Runtime.getRuntime().totalMemory() / 1024 /1024;
        //返回 JVM 堆的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 /1024;

        System.out.println("-Xms : "+initalMemory + "M");
        System.out.println("-Xmx : "+maxMemory + "M");
    }
}