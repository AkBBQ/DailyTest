package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.Training;


/**
 * 二个线程交替输出 1212121212
 *
 * 采用wait()和notify()
 */
public class AddTest {

    public static void main(String[] args) {
        Object o = new Object();
        MyThread myThread1 = new MyThread(1, o);
        MyThread myThread2 = new MyThread(2, o);
        myThread1.start();
        myThread2.start();
    }

    public static class MyThread extends Thread {
        private final int number;
        private final Object object;

        public MyThread(int number, Object object) {
            this.number = number;
            this.object = object;
        }

        public void run() {
            synchronized (object) {
                for (int i = 0; i < 5; i++) {
                    try {
                        //线程1先执行 唤醒其他等待的线程2 第一次的话没有等待的线程2 直接往下执行
                        object.notify();
                        System.out.println("" + number);
                        //线程1输出了 1 wait 等待线程2 唤醒
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


}