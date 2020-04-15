package JUC;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package JUC
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/4/11 5:45 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();


        while (true) {
                if (threadDemo.isFlag()) {
                    System.out.println("主线程读到的flag = " + threadDemo.isFlag());
                    break;
                }
        }

    }


    public static class ThreadDemo implements Runnable {
        private volatile boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("ThreadDemo线程修改后的flag = " + isFlag());
        }
    }
}