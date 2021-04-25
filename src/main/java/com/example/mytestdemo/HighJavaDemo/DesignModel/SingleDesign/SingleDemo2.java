package com.example.mytestdemo.HighJavaDemo.DesignModel.SingleDesign;

/**
 * 懒汉式(延迟加载)
 * 一般情况下是多线程不安全的
 */

public class SingleDemo2 {

    private static SingleDemo2 singleDemo2;

    private SingleDemo2() {
    }

    public static synchronized SingleDemo2 getSingleDemo2() {
        if (null == singleDemo2) {
            return new SingleDemo2();
        }
        return singleDemo2;
    }

    public void hello() {
        System.out.println("懒汉式");
    }

}