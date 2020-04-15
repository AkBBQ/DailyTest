package JUC.xiancheng.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package JUC.xiancheng.SynchronizedDemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/4/13 10:26 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        for(int j = 0;j<10;j++){
            Thread thread = new Thread(threadDemo2);
            thread.start();
        }
    }

    public static class ThreadDemo2 extends Thread {
        //公平锁
        Lock localLock = new ReentrantLock(true);
        private int i = 0;

        public int getI() {
            return i++;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                localLock.lock();
                System.out.println(getI());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                localLock.unlock();
            }
        }
    }
}