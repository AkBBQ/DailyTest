package com.example.mytestdemo.JavaDemo.Abstract;

import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Abstract
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/22 10:21 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Service
public abstract class BuyMobile implements BuySomethingService {

    @Override
    public String getName(String name) {
        return null;
    }

    @Override
    public String getPlace(String place) {
        return null;
    }

    @Override
    public String buySomething(String thing) {

        return buyWhat(thing);
    }

    protected abstract String buyWhat(String things);
}