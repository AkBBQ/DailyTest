package com.example.mytestdemo.JavaDemo.Abstract;

import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Abstract
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/22 10:23 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Service
public class Iphone extends BuyMobile {

    @Override
    public String getName(String name) {
        return "苹果 买手机";
    }

    @Override
    public String getPlace(String place) {
        return "苹果 买手机的地方是美国";
    }

    @Override
    protected String buyWhat(String things) {
        return "Iphone 手机";
    }
}