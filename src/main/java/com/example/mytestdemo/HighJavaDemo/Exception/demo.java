package com.example.mytestdemo.HighJavaDemo.Exception;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package Exception
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2020/5/29 12:28 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class demo {

    public static void main(String[] args) {
        String start = start();
        System.out.println(start);
    }

    public static String start() {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
            return "你妈的异常了";
        }
        return "good";

    }

    public static void method1() {
        method2();
        throw new RuntimeException();

    }

    public static void method2() {
        method3();

    }

    public static void method3() {

    }
}