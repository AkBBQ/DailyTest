package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoOne;


/**
 * Sell 实现类 (被代理类)
 */

public class UserServiceImpl implements UserService {
    @Override
    public void Sell() {
        System.out.println("委托类生产");
    }
}