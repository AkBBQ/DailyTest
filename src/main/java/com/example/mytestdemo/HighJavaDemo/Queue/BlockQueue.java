package com.example.mytestdemo.HighJavaDemo.Queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列
 */

public class BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        //可以控制是否为公平阻塞队列 先阻塞 空余下来 先出队
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(10, true);
        //二种阻塞的方法
        queue.put(1);
        queue.take();


    }
}