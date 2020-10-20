package com.example.mytestdemo.HighJavaDemo.proxy.JDK.demoOne;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理必须要有接口 动态代理
 */

public class UserServiceHandler implements InvocationHandler {

    private Object object;

    public UserServiceHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        Object o= method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return o;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserServiceHandler userServiceHandler = new UserServiceHandler(userService);
        //代理类
        UserService newProxyInstance = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), userServiceHandler);
        newProxyInstance.Sell();
    }

}