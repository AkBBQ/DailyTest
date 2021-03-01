package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 举个例子，就像生活中我们会约朋友们到某个餐厅一起吃饭，有些朋友可能会早到，有些朋友可能会晚到，但是这个餐厅规定必须等到所有人到齐之后才会让我们进去。这里的朋友们就是各个线程，餐厅就是 CyclicBarrier。
 *
 * 作者：一团捞面
 * 链接：https://www.jianshu.com/p/333fd8faa56e
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class CycleBarrierDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, myThread);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {

            executorService.execute(() -> {
                System.out.println("当前线程" + Thread.currentThread().getName() + "完成第一次任务");
                try {
                    cyclicBarrier.await();
                    Thread.sleep(10000L);
                    System.out.println("当前线程" + Thread.currentThread().getName() + "完成第二次任务");
                    cyclicBarrier.await();
                    Thread.sleep(10000L);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

    }

    public static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程" + Thread.currentThread().getName() + "最后此阶段最后一个任务！");
        }
    }
}