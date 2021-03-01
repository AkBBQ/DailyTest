package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.tools;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量 用来控制只有几个线程能访问某个资源
 *
 * 假如我们要去游泳池游泳，泳池一共有6条泳道，每条泳道只能有1个人在上面使用。
 * 每个人去游泳之前要先 acquire() 一下获取许可证，如果有空闲泳道就可以去游泳
 * ；如果没有空闲泳道，就只能阻塞等待。游完泳之后，再 release() 一下释放许可证，
 * 释放出该泳道的使用权，确保下一个人 acquire() 的时候可以获取可用泳道，继续游泳。如果泳道上都有人了，再有人过来游泳，就需要等待其他人
 * ————————————————
 * 版权声明：本文为CSDN博主「凉凉的西瓜」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_42815754/article/details/88595034
 */

public class SemaphoreDemo {

    public static void main(String[] args) {

        int permits = 3;
        Semaphore semaphore = new Semaphore(permits);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i =0;i<10 ;i++ ) {
            executorService.execute(() -> {
                try {
                    //获取信号量 参数获取几个
                    semaphore.acquire(2);
                    System.out.println("当前线程名:" + Thread.currentThread().getName() + "拿到信号量了,信号量还剩" + semaphore.availablePermits() + "可用");
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放信号量 释放几个
                semaphore.release(2);
                System.out.println("当前线程名:" + Thread.currentThread().getName() + "执行完毕,信号量还剩" + semaphore.availablePermits() + "可用");

            });
        }


    }


}