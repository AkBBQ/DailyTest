package com.example.mytestdemo.JavaDemo.Abstract;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Abstract
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/22 10:21 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public abstract class BuyMobile implements BuySomethingService {

    @Override
    public void buySomething() {
        buyWhat();
    }

    abstract void buyWhat();

}