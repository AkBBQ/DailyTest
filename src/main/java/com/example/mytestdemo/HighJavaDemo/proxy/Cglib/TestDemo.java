package com.example.mytestdemo.HighJavaDemo.proxy.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Proxy;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.proxy.Cglib
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/20 4:30 下午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class TestDemo {
    public static void main(String[] args) {
        //创建目标对象
        TransferService target = new TransferService();
        //创建代理对象
        TransferService proxy = (TransferService) Enhancer.create(target.getClass(), new TransferInterceptor());
        if (Proxy.isProxyClass(proxy.getClass())) {
            System.out.println("代理类");
        }
        proxy.doTransfer();
    }
}