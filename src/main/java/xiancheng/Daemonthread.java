package xiancheng;

/**
 * 守护线程
 *
 * 守护线程和主线程一起销毁
 * GC线程(垃圾回收线程也属于守护线程)
 */

public class Daemonthread {



    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                try {
                    //休眠1秒钟
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println("子线程:" + i);
                }
            }
        });
        //讲当前线程设置成守护线程
        thread.setDaemon(true);
        thread.start();

        //主线程
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主要线程:" + i);
        }
        System.out.println("主要线程结束-------");



    }

}