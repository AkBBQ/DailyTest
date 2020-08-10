package JUC.xiancheng.TImeTestDemo;

import java.util.concurrent.*;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package JUC.xiancheng.TImeTestDemo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/8/10 6:02 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class TimeTest {

    public static void main(String[] args) {

        Long t1 = System.currentTimeMillis();
        System.out.println(t1);
        CompletableFuture<Void> one = CompletableFuture.runAsync(One::hello,Excutore.getMyPool());
        CompletableFuture<Void> two = CompletableFuture.runAsync(Two::hai,Excutore.getMyPool());
        CompletableFuture.allOf(one,two).join();
        Long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

    }

    public static class One {
        public static  void hello() {
            try {
                //2s
                Thread.sleep(200);
                System.out.println("2s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class Two {

        public static void hai() {
            try {
                //10S
                Thread.sleep(1000);
                System.out.println("10s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Excutore {
        public static volatile ThreadPoolExecutor myPool = null;

        public  static ThreadPoolExecutor getMyPool() {
            if (null != myPool) {
                return myPool;
            }
            synchronized (Excutore.class) {
                if (null != myPool) {
                    return myPool;
                }
                myPool = new ThreadPoolExecutor(2,
                        5,
                        10000L,
                        TimeUnit.MINUTES,
                        new LinkedBlockingQueue<>(1024),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());
                return myPool;
            }
        }

    }
}