package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 开辟线程池将count累加到5000
 */

public class CommanDemo {
    public static int count = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (CommanDemo.class){
                    count++;
                    }
                }
            });
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(count);
    }
}