package com.example.mytestdemo.JavaDemo.demo;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.GetReflectDemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/1/17 2:11 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello");
        Thread.currentThread().setPriority(1);
        System.out.println("当前线程名字:"+Thread.currentThread().getName());
        System.out.println("优先级为"+Thread.currentThread().getPriority());
        System.out.println("线程编号"+Thread.currentThread().getId());
    }
}