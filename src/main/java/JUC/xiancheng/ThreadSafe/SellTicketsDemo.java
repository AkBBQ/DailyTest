package JUC.xiancheng.ThreadSafe;

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池 + lock锁 实现多线程卖票
 */

public class SellTicketsDemo {
    public static void main(String[] args) {
        //1、使用自定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        Sell sell = new Sell();

        pool.execute(() -> sell.sell());

        //👆等价于👇
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                sell.sell();
//            }
//        });
        pool.shutdown();

        //2、使用Feature 执行异步线程
        CompletableFuture.runAsync(() -> sell.sell());

    }

    @Data
    public static class Sell {
        //Lock锁
        Lock lock = new ReentrantLock();

        //火车票数量
        int i = 20;

        private void sell() {
            try {
                lock.lock();
                while (i > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第:" + (20 - getI() + 1) + "张票");
                    i--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //必须在finally中释放
                lock.unlock();
            }
        }

    }
}