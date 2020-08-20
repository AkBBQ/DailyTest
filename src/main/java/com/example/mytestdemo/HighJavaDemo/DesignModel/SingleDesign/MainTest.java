package com.example.mytestdemo.HighJavaDemo.DesignModel.SingleDesign;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package DesignModel.SingleDesign
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/4/5 1:07 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class MainTest {

    public static void main(String[] args) {
        //饿汉式
        SingleDemo1 singleDemo1 = SingleDemo1.getSingleDemo1();
        singleDemo1.hello();

        //懒汉式
        SingleDemo2 singleDemo2 = SingleDemo2.getSingleDemo2();
        singleDemo2.hello();

        //多线程下单例模式线程安全问题

        //饿汉式 线程安全
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new SingleOne();
            threads[i].start();
        }


        //懒汉式 线程不安全(会创造多个不同的实例)
        Thread[] thread2 = new Thread[10];
        for (int k = 0; k < thread2.length; k++) {
            thread2[k] = new SingleTwo();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread2[k].start();
        }


    }



    //饿汉式 是 天生的线程安全的
    private static class SingleOne extends Thread {

        private static SingleOne singleOne = new SingleOne();

        private SingleOne(){

        }

        public static SingleOne getSingleOne() {
            return singleOne;
        }

        @Override
        public void run() {
            System.out.println(singleOne.hashCode());
        }

    }


    /**
     * 懒汉式 是 线程不安全的
     */
    public static class SingleTwo  extends Thread {

        private static SingleTwo singleTwo;

        private SingleTwo() {
        }

        public static synchronized SingleTwo getSingleDemo2() {
            if (null == singleTwo) {
                return new SingleTwo();
            }
            return singleTwo;
        }

        public void hello() {
            System.out.println("懒汉式");
        }

        @Override
        public void run() {
            System.out.println("懒汉式Hashcode:" + SingleTwo.getSingleDemo2().hashCode());
        }
    }

}