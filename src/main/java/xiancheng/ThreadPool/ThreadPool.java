package xiancheng.ThreadPool;

import java.util.concurrent.*;

/**
 * 线程池管理多线程
 * xiancheng.ThreadSafe.ThreadSafe 比普通线程的好处是好管理线程
 */

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);


            ThreadDemo threadDemo = new ThreadDemo();
            //下面用法不合理 一般线程池配合for循环使用
            Thread thread1 = new Thread(threadDemo,"线程1");
            Thread thread2 = new Thread(threadDemo,"线程2");
            executorService.submit(thread1);
            executorService.submit(thread2);

    }

}

      class ThreadDemo implements Runnable{
        @Override
        public void run() {
            for(int i =0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+"执行"+i);
            }
        }
    }

