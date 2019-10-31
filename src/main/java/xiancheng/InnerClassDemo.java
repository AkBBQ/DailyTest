package xiancheng;


/**
 * 线程创建之 匿名内部类
 */

public class InnerClassDemo {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });

        thread.start();

    }
}