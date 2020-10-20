package com.example.mytestdemo.HighJavaDemo.proxy.StaticProxy;

/**
 * 静态代理类
 * 将固定的代理对象的引用放入到静态代理构造函数中 加强代理类方法
 */

public class Proxy implements SellService {

    private SellServiceImpl producer;

    public Proxy(SellServiceImpl producer) {
        this.producer = producer;
    }

    @Override
    public void Sell() {
        System.out.println("我是代理类,可以做预处理");
        producer.Sell();
        System.out.println("我是代理类,可以做其他处理");

    }

    public static void main(String[] args) {
        //将被代理的类的引用对象放入代理类中
        Proxy proxy = new Proxy(new SellServiceImpl());
        proxy.Sell();
    }
}