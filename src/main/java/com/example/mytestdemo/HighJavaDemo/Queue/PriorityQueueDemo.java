package com.example.mytestdemo.HighJavaDemo.Queue;

import java.util.PriorityQueue;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.Queue
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/12/4 9:49 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(5);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

    }
}