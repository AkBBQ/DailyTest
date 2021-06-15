package com.example.mytestdemo.JavaDemo.Abstract;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.JavaDemo.Abstract
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/10/22 10:33 上午
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class TestDemo {
    public static void main(String[] args) {
        BuySomethingService buySomethingService = new HuaWei();
        String s = buySomethingService.buySomething("");
        System.out.println(s);
        System.out.println(buySomethingService.getName(""));

        System.out.println(buySomethingService.getPlace(""));


        BuyMobile buyMobile = new Iphone();
        System.out.println(buyMobile.buySomething(""));
        System.out.println(buyMobile.getName(""));
        System.out.println(buyMobile.getPlace(""));

    }
}