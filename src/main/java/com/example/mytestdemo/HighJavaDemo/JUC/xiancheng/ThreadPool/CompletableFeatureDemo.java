package com.example.mytestdemo.HighJavaDemo.JUC.xiancheng.ThreadPool;

import com.alibaba.fastjson.JSON;
import com.example.mytestdemo.Config.ExecutorConstant;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;


/**
 * jps
 * jstack pid 可以看到线程池的5个线程
 * @author sunjie
 */
public class CompletableFeatureDemo {


    public static void main(String[] args) {
        Order order = new Order();

        CompletableFuture<Void> c1 = CompletableFuture.runAsync(() -> order.setGoods(Arrays.asList("铅笔", "橡皮")), ExecutorConstant.getExecutor());
        CompletableFuture<Void> c2 = CompletableFuture.runAsync(() -> order.setPhones(Arrays.asList("15251800011", "15251800013")), ExecutorConstant.getExecutor());
        CompletableFuture<Void> c3 = CompletableFuture.runAsync(() -> order.setUsers(Arrays.asList("张三", "李四")), ExecutorConstant.getExecutor());

        CompletableFuture.allOf(c1, c2, c3).join();

        System.out.println(JSON.toJSONString(order));
    }

    @Data
    public static class Order {
        private List<String> goods;
        private List<String> phones;
        private List<String> users;

    }
}
