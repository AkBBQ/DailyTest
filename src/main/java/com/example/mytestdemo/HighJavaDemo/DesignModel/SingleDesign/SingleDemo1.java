package com.example.mytestdemo.HighJavaDemo.DesignModel.SingleDesign;

/**
 * 单例设计模式
 * <p>
 * 饿汉式(立即加载)
 * <p>
 * 构造方法私有化 外部无法产生实例化对象，只能通过get方法获取实例
 */

public class SingleDemo1 {


    private static SingleDemo1 singleDemo1 = new SingleDemo1();

    private SingleDemo1() {
    }

    public static SingleDemo1 getSingleDemo1() {
        return singleDemo1;
    }

    public void hello() {
        System.out.println("饿汉式");
    }

}