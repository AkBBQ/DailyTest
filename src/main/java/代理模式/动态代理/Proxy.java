package 代理模式.动态代理;

import sun.dc.pr.PRError;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package 代理模式.动态代理
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/4/1 12:21 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class Proxy implements InvocationHandler {

    private Object object;

    public Proxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        Sell sell = (Sell) new Producer();
    }
}