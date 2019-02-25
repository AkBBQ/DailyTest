package com.example.mytestdemo.demo;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.demo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/1/17 4:40 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */
public class HeelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("当前线程名字:"+Thread.currentThread().getName());
        System.out.println("优先级为"+Thread.currentThread().getPriority());
        System.out.println("线程编号"+Thread.currentThread().getId());
        System.out.println("骚年，欢迎光临！");
    }
}
