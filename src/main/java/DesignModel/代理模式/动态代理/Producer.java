package DesignModel.代理模式.动态代理;

import DesignModel.代理模式.静态代理.Sell;

/**
 * 被代理类
 */

public class Producer implements Sell {
    @Override
    public void Sell() {
        System.out.println("委托类生产");
    }
}