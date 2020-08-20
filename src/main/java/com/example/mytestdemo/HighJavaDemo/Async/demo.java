package com.example.mytestdemo.HighJavaDemo.Async;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture 实验
 */

public class demo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        CompletableFuture.runAsync(()->{
                    for(int j = 0 ; j<=100 ; j++){
                        System.out.println("次要线程:"+j);
                        while (j == 20){
                            throw new RuntimeException("异常啦！");
                        }
                    }
                }
        ).exceptionally(e -> {
            System.out.println(e);
            return null;
        });

        //开启另一个线程去执行

        for(int i = 0 ; i<=100 ; i++){
            System.out.println("主线程:"+i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}