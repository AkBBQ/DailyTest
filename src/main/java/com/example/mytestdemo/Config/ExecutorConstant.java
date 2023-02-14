package com.example.mytestdemo.Config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * 线程池
 * volatile 和 synchronized 双重锁检查
 *
 * @author sunjie
 */
public class ExecutorConstant {


    private static final int CORE_THREADS = 5;
    private static final int MAX_THREADS = 20;

    private static volatile ExecutorService executor = null;

    private static LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();


    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("mytest-executor-pool-%d").build();

    public static ExecutorService getExecutor() {
        if (executor != null) {
            return executor;
        }
        synchronized (ExecutorConstant.class) {
            executor = new ThreadPoolExecutor(CORE_THREADS, MAX_THREADS, 0, TimeUnit.SECONDS, taskQueue, threadFactory);
            return executor;
        }
    }
}
