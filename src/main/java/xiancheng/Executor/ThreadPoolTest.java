package xiancheng.Executor;

import java.util.concurrent.*;

/**
 * Executors 提供的四种线程池
 *
 *
 * 　一般如果线程池任务队列采用LinkedBlockingQueue队列的话，那么不会拒绝任何任务（因为队列大小没有限制），这种情况下，ThreadPoolExecutor最多仅会按照最小线程数来创建线程，也就是说线程池大小被忽略了。
 *
 * 如果线程池任务队列采用ArrayBlockingQueue队列的话，那么ThreadPoolExecutor将会采取一个非常负责的算法，比如假定线程池的最小线程数为4，最大为8所用的ArrayBlockingQueue最大为10。随着任务到达并被放到队列中，线程池中最多运行4个线程（即最小线程数）。
 *
 * 即使队列完全填满，也就是说有10个处于等待状态的任务，ThreadPoolExecutor也只会利用4个线程。如果队列已满，而又有新任务进来，此时才会启动一个新线程，这里不会因为队列已满而拒接该任务，相反会启动一个新线程。新线程会运行队列中的
 *
 * 第一个任务，为新来的任务腾出空间。这个算法背后的理念是：该池大部分时间仅使用核心线程（4个），即使有适量的任务在队列中等待运行。这时线程池就可以用作节流阀。如果挤压的请求变得非常多，这时该池就会尝试运行更多的线程来清理；
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        SingleThreadPool();
//        newFixedThreadPool();
//        newScheduledThreadPool();
        newCachedThreadPool();
    }


    /**
     * 一:newSingleThreadExecutor
     * 创建只有一个线程的线程池，且线程的存活时间是无限的；当该线程正繁忙时，对于新任务会进入阻塞队列中(无界的阻塞队列)
     * 适用：一个任务一个任务执行的场景
     */
    private static void SingleThreadPool() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            try {
                //线程休眠2s
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                System.out.println("当前线程" + Thread.currentThread().getName());
                System.out.println("干事情");
            });

        }
    }

    /**
     * 二:newFixedThreadPool
     * 通俗：创建可容纳固定数量线程的池子，每个线程的存活时间是无限的，当池子满了就不在添加线程了；如果池中的所有线程均在繁忙状态，对于新任务会进入阻塞队列中(无界的阻塞队列)
     * 适用：执行长期的任务，性能好很多
     */
    private static void newFixedThreadPool() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                System.out.println("当前线程:" + Thread.currentThread().getName() + "干活");
            });
        }
    }

    /**
     * 三:newScheduledThreadPool
     * 通俗：创建一个固定大小的线程池，线程池内线程存活时间无限制，线程池可以支持定时及周期性任务执行，如果所有线程均处于繁忙状态，对于新任务会进入DelayedWorkQueue队列中，这是一种按照超时时间排序的队列结构
     * 适用：周期性执行任务的场景
     */
    private static void newScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        Runnable r1 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:3秒后执行");
        scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);


        Runnable r2 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:延迟2秒后每3秒执行一次");
        scheduledThreadPool.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);


        Runnable r3 = () -> System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行:普通任务");
        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.execute(r3);
        }
    }

    /**
     * 四:newCachedThreadPool
     * 通俗：当有新任务到来，则插入到SynchronousQueue中，由于SynchronousQueue是同步队列，
     * 因此会在池中寻找可用线程来执行，若有可以线程则执行，
     * 若没有可用线程则创建一个线程来执行该任务；若池中线程空闲时间超过指定大小，则该线程会被销毁。
     * 适用：执行很多短期异步的小程序或者负载较轻的服务器
     */
    private static void newCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<500;i++){

            executorService.execute(()-> System.out.println("当前线程:"+Thread.currentThread().getName()+"开始干活"));

        }
    }
}