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
        while (sell.getI() > 0) {
            pool.execute(() -> sell.sell());
        }
        pool.shutdown();
    }

    @Data
    public static class Sell {
        //Lock锁
        Lock lock = new ReentrantLock();

        //火车票数量
        int i = 100;

        private void sell() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "正在卖第:" + (100 - getI() + 1) + "张票");
                i--;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //必须在finally中释放
                lock.unlock();
            }
        }

    }
}