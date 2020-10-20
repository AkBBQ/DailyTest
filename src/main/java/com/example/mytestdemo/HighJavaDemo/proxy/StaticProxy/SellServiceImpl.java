package com.example.mytestdemo.HighJavaDemo.proxy.StaticProxy;

/**
 * sell实现类 (被代理类)
 */

public class SellServiceImpl implements SellService {
    @Override
    public void Sell() {
        System.out.println("委托类生产");
    }
}