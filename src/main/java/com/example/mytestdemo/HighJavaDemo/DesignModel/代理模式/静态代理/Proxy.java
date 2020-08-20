package com.example.mytestdemo.HighJavaDemo.DesignModel.代理模式.静态代理;

/**
 * 代理类
 */

public class Proxy implements Sell {

    private Producer producer;

    public Proxy(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void Sell() {
        System.out.println("我是代理类,可以做预处理");
        producer.Sell();
        System.out.println("我是代理类,可以做其他处理");

    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Producer());
        proxy.Sell();
    }
}