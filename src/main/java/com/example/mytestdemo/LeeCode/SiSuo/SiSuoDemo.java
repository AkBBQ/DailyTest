package com.example.mytestdemo.LeeCode.SiSuo;

import lombok.Data;

/**
 * 手写死锁的场景
 */

public class SiSuoDemo {

    public static void main(String[] args) {

        //一个对象
        DeadLock myThread = new DeadLock(new Object(), new Object());

        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.funA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.funB();
            }
        }).start();


    }


    @Data
    public static class DeadLock {
        private Object a;
        private Object b;


        public DeadLock(Object a, Object b) {
            this.a = a;
            this.b = b;
        }

        //获取一个锁不释放去获取另外一个
        public void funA() {
            synchronized (a) {
                System.out.println("当前线程说:" + Thread.currentThread().getName() + "老子有A锁");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("当前线程说:" + Thread.currentThread().getName() + "老子有B锁");
                }
            }
        }

        //获取一个锁不释放去获取另外一个
        public void funB() {
            synchronized (b) {
                System.out.println("当前线程说:" + Thread.currentThread().getName() + "老子有B锁");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println("当前线程说:" + Thread.currentThread().getName() + "老子有A锁");
                }
            }
        }
    }
}