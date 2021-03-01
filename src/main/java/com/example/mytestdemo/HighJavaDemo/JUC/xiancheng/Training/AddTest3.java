package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.Training;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.Training
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2021/3/1 3:31 下午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class AddTest3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        MyThread myThread1 = new MyThread("线程一", lock, 1, condition);
        MyThread myThread2 = new MyThread("线程二", lock, 2, condition);

        myThread1.start();
        myThread2.start();


    }

    public static class MyThread extends Thread {

        String name;
        final Lock lock;
        final int num;
        final Condition condition;

        public MyThread(String name, Lock lock, int num, Condition condition) {
            super(name);
            this.lock = lock;
            this.num = num;
            this.condition = condition;
        }


        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    lock.lock();
                    condition.signal();
                    Thread.sleep(10000L);
                    System.out.println(Thread.currentThread().getName() + "输出" + num);
                    condition.await();
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}