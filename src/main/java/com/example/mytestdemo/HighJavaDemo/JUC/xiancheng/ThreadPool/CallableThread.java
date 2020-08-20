package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.ThreadPool;


import java.util.concurrent.*;
import java.util.*;

/**
 * Callable可以拿到异步线程结果
 */

public class CallableThread {
    public static void main(String[] args) {
        //申明一个单核的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();



        //Callable的结合
        Set<Callable<String>> callables = new HashSet<>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "1";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "2";
            }
        });

        callables.add(() -> "3");



        //有回调结果的线程
        Callable<String> callable = () -> "111";

        //Future模式是多线程设计常用的一种设计模式。
        // Future模式可以理解成：我有一个任务，提交给了Future，
        // Future替我完成这个任务。期间我自己可以去做任何想做的事情。
        // 一段时间之后，我就便可以从Future那儿取出结果。
        FutureTask<String> futureTask = new FutureTask<>(callable);

        //线程池执行
        executorService.submit(futureTask);

        //execute用来执行一个Runnable线程
        executorService.execute(() -> System.out.println("123"));


        try {

            //方法 invokeAny() 接收壹個包含 Callable 对象的集合作为参数。
            // 调用该方法不会返回 Future 对象，而是返回集合中某壹個 Callable 对象的结果，
            //而且无法保证调用之后返回的结果是哪壹個 Callable，
            // 只知道它是这些 Callable 中壹個执行结束的 Callable 对象。
            String s = executorService.invokeAny(callables);

            List<Future<String>> futures = executorService.invokeAll(callables);
            futures.forEach(item->{
                try {
                    System.out.println("所有Callable线程回调的结果"+item.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });

            System.out.println("invokeAny返回的结果是:"+s);

            if (futureTask.isDone()) {
                System.out.println("任务执行完毕");
            }



            //拿到线程执行结果，如果没拿到就阻塞等待直到拿到结果
            //在future.get()的地方等待future返回的结果，这时又变成同步操作。
            // 要么使用isDone()轮询地判断Future是否完成，这样会耗费CPU的资源。
            String result = futureTask.get();
            System.out.println("线程执行结果:" + result + "当前线程的名字:"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}