package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.tools;


import java.util.concurrent.CountDownLatch;

/**
 * 计数器
 */

public class CountDownLatchDemo {
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 5; i++) {
            try {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("当前线程=" + Thread.currentThread().getName() + "跑完了");
                    }
                });
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("跑完了 - 1");
                countDownLatch.countDown();
            }
        }

        //等待所有子线程跑完
        countDownLatch.await();
        System.out.println("main函数继续跑");


    }

}


