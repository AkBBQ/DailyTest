package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于接口实现的JDK动态代理实例
 *
 * @param <T>
 */

public class JdkHandler<T> implements InvocationHandler {

    private T target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doPre();
        Object invoke = method.invoke(target, args);
        doFinish();
        return invoke;
    }

    public JdkHandler(T target) {
        this.target = target;
    }

    private void doPre(){
        System.out.println("准备工作中......");
    }

    private void doFinish(){
        System.out.println("收尾工作中......");
    }
}