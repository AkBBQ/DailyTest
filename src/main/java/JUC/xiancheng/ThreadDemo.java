package JUC.xiancheng;

/**
 * 线程使用方式一 继承Thread类
 */

public class ThreadDemo {

    public static void main(String[] args) {
        System.out.println("main方法开始----");

        //创建子线程
        OneThred oneThred = new OneThred();
        //执行
        oneThred.start();

        for (int i = 0 ; i< 100 ; i++){
            System.out.println("主线程: i="+i);
        }
        System.out.println("main方法结束----");
    }
   static class OneThred extends Thread{
        @Override
        public void run() {
            for (int i =0 ;i<1000 ;i++){
                System.out.println("子线程: i="+i);
            }
        }
    }
}