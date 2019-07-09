package com.example.mytestdemo.BigDecimal;

import java.math.BigDecimal;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.BigDecimal
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/7/2 11:09 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        BigDecimal a =  new BigDecimal("0");
        BigDecimal b =  new BigDecimal("1");
        BigDecimal c =a.add(b);
        System.out.println(c);
    }
}