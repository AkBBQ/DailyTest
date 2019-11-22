package 代理模式.静态代理;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package 代理模式.静态代理
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/11/22 5:42 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */


public class Producer implements Sell {
    @Override
    public void Sell() {
        System.out.println("委托类生产");
    }
}