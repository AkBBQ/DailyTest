package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadAndWriteLock raw = new ReadAndWriteLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> raw.get()).start();
            //写线程
            new Thread(() -> raw.set((int) (Math.random() * 101)), "Write").start();
        }
    }


    public static class ReadAndWriteLock {
        //模拟共享资源--Number
        private int number = 0;
        // 实际实现类--ReentrantReadWriteLock，默认非公平模式
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


        //读操作
        private void get() {
            readWriteLock.readLock().lock();
            try {
                System.out.println("当前线程" + Thread.currentThread().getName() + "读到的内容是:" + number);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
        }

        //写操作
        public int set(int number) {
            readWriteLock.writeLock().lock();
            try {
                this.number = number;
                System.out.println("当前线程" + Thread.currentThread().getName() + "写进去的内容是:" + number);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }
            return number;
        }

    }

}