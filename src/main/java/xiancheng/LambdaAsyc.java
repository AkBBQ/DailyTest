package xiancheng;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Java8通过函数式编程CompletableFuture实现异步
 * <p>
 * runAsync 没有返回值
 * supplyAsync 有返回值
 */

public class LambdaAsyc {
    public static void main(String[] args) {
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("222");
            }
        });
        //lambda简化写法
        CompletableFuture.runAsync(() -> System.out.println("123"));

        try {
            String a = CompletableFuture.supplyAsync(() -> "Hello")
                     .thenApply(s -> s + "Word")
                     .whenComplete((s, throwable) -> System.out.println(s)).get();

            System.out.println("异步执行结果:"+a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}