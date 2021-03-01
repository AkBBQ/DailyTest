package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.tools;


import java.util.concurrent.CountDownLatch;

/**
 * 栅栏
 */

public class CountDownLatchDemo {
    private static final CountDownLatch otherCountDown = new CountDownLatch(5);

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new MyThread(), String.valueOf(i));
            thread.start();
        }
        try {
            //判断子线程是否跑完
            otherCountDown.await();
            System.out.println("main函数继续跑");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("当前线程:" + Thread.currentThread().getName() + "开始执行");
            } finally {
                //子线程执行完毕，计数器减1
                otherCountDown.countDown();
            }
        }
    }

}