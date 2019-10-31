package com.example.mytestdemo.compare;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package com.example.mytestdemo.compare
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/6/27 9:28 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {
    public static void main(String[] args) {
        int a = 200;
        Integer b = new Integer(200);
        System.out.println(b.equals(a));
        System.out.println(a == b);
    }
}