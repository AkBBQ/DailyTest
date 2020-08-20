package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS实现
 */

public class CasDemo {
    //原子类
    public static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    count.getAndIncrement();
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