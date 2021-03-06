package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.ThreadSafe;

import java.time.LocalDateTime;

/**
 * 线程安全 多窗口抢火车票
 */


public class SynchronizedDemo {
    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        SallThread sallThread = new SallThread();
        Thread t1 = new Thread(sallThread);
        Thread t2 = new Thread(sallThread);
        t1.start();
        //等待t1线程全部执执行结束
        //t1.join();
        t2.start();
    }

    static class SallThread implements Runnable {
        //100张火车票
        private int count = 10;

        @Override
        public void run() {
            while (count > 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sell2();
            }
        }

        // 内置互斥锁 synchronized
        //当线程进入方法时,自动会获取锁(互斥锁),一旦锁被其他线程占用的时候,该线程就会等待
        //程序执行完毕会释放锁.缺点:降低了程序的效率

        //synchronized实现一:同步方法
        public synchronized void sell() {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "出售第" + (10 - count + 1) + "张火车票");
                count--;
            }
        }

        //synchronized实现二:方法代码块
        public void sell2() {
            synchronized (object) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "出售第" + (10 - count + 1) + "张火车票");
                    System.out.println(LocalDateTime.now());
                    count--;
                }
            }
        }


        //synchronized实现三:作用域为对象
        public void sell3() {
            synchronized (SynchronizedDemo.class) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "出售第" + (10 - count + 1) + "张火车票");
                    count--;
                }
            }
        }
    }
}