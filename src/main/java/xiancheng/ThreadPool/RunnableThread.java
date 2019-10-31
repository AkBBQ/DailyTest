package xiancheng.ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Runnable也能拿到回调？
 */

public class RunnableThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Demo demo = new Demo();
        Future<Class<String>> submit = executorService.submit(demo, String.class);
        if(submit.isDone()){
            try {
                Class<String> stringClass = submit.get();
                System.out.println(stringClass.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Demo implements Runnable{
        @Override
        public void run() {
            System.out.println(test());
        }

        private String test(){
            return "测试数据";
        }
    }
}