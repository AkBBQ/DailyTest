package com.example.mytestdemo.HighJavaDemo.Queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package Queue
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/4/9 3:59 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        //队列中新增一个元素
        queue.add("sun");
        queue.offer("jie");

        queue.remove("sun");
        queue.poll();


        System.out.println(queue.poll());
    }
}