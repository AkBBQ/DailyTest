package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.Training;


/**
 * 二个线程交替输出 1212121212
 *
 * 采用信号量 也就是volatile关键字 主内存可见性
 */
public class AddTest2 {
    //信号量
    private volatile static boolean flag = true;

    private static Integer i = 5;
    private static Integer j = 5;

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread2().start();
    }

    public static class MyThread extends Thread {


        @Override
        public void run() {
            while (i > 0) {
                if (flag) {
                    System.out.println(1);
                    flag = false;
                    i--;
                }
            }
        }

    }

    public static class MyThread2 extends Thread {

        @Override
        public void run() {
            while (j > 0) {
                if (!flag) {
                    System.out.println(2);
                    flag = true;
                    j--;
                }
            }
        }
    }
}