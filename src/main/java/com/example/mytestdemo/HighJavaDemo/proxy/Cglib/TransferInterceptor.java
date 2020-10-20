package com.example.mytestdemo.HighJavaDemo.proxy.Cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.HighJavaDemo.proxy.Cglib
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/20 4:14 下午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class TransferInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.doBefore();
        return methodProxy.invokeSuper(o, objects);
    }

    private void doBefore() {
        System.out.println("准备发起转账");
    }
}