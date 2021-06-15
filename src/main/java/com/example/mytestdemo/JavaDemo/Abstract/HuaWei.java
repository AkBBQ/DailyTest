package com.example.mytestdemo.JavaDemo.Abstract;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Abstract
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/22 10:32 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class HuaWei extends BuyMobile {

    @Override
    public String getName(String name) {
        return "HuaWei 买手机";
    }

    @Override
    public String getPlace(String place) {
        return "HuaWei 买手机的地方是中国";
    }

    @Override
    protected String buyWhat(String things) {
        return "HuaWei手机";
    }
}