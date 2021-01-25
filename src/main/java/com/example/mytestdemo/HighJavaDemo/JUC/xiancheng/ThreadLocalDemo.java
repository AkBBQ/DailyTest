package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2021/1/21 6:52 下午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();
        threadLocal.set("haha");
        System.out.println(threadLocal.get());
    }
}