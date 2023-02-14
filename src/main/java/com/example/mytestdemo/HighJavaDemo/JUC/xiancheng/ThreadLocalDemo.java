package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng;

/**
 set key为当前线程
 */

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>();

        new Thread(()->{
            threadLocal.set("子线程");
            System.out.println(threadLocal.get());
            threadLocal.remove();
        }).start();

        threadLocal.set("主线程");
        System.out.println(threadLocal.get());
        threadLocal.remove();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}