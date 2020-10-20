package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo;

import java.lang.reflect.Proxy;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoTwo
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/20 11:45 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class TestUseDemo {

    public static void main(String[] args) {

        //创建一个实例对象，这个对象是被代理的对象，委托类
        LoginService user = new LoginServiceImpl("孙杰", "123456");

        //创建一个与代理类相关联的InvocationHandler,每一个代理类都有一个关联的 InvocationHandler，并将代理类引用传递进去
        JdkHandler<LoginService> jdkProxy = new JdkHandler<>(user);

        //创建一个 代理对象 newProxyInstance 来代理 user，创建的代理对象的每个执行方法都会被替换执行Invocation接口中的invoke方法
        LoginService newProxyInstance = (LoginService) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), jdkProxy);
        newProxyInstance.login("孙杰","123456");
    }
}