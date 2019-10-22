package xiancheng;

/**
 * 线程实现之 实现Runnable接口
 */

public class RunnableDemo {

    public static void main(String[] args) {
        //新建一个
        ThreadDemo threadDemo = new ThreadDemo();
        //传进去去
        Thread thread = new Thread(threadDemo);
        thread.start();

    }

    static class ThreadDemo implements Runnable{

        @Override
        public void run() {
         for(int i =0;i<100;i++){
             System.out.println(""+i);
         }
        }
    }
}